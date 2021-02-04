// Template for parsing an ELF file to print its symbol table
// UPDATED: Tue Dec  8 03:27:18 PM CST 2020 
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/mman.h>
#include <elf.h>

// The below macros help to prevent errors when doing pointer
// arithmetic. Adding an offset to a pointer is the most common
// operation here while the other macros may not be needed.

#define PTR_PLUS_BYTES(ptr,off) ((void *) (((size_t) (ptr)) + ((size_t) (off))))
// macro to add a byte offset to a pointer, arguments are a pointer
// and a # of bytes (usually size_t)

#define PTR_MINUS_BYTES(ptr,off) ((void *) (((size_t) (ptr)) - ((size_t) (off))))
// macro to subtract a byte offset from a pointer, arguments are a pointer
// and a # of bytes (usually size_t)

#define PTR_MINUS_PTR(ptr,ptq) ((long) (((size_t) (ptr)) - ((size_t) (ptq))))
// macro to subtract one pointer from another

int DEBUG = 0;                  
// Controls whether to print debug messages
// Can be used in conditionals like if(DEBUG){ ... }
// and running 'showsym -d x.o' will set DEBUG=1

int main(int argc, char *argv[]){
  if(argc < 2){
    printf("usage: %s [-d] <file>\n",argv[0]);
    return 0;
  }

  char *objfile_name = argv[1];

  // check for debug mode
  if(argc >=3){
    if(strcmp("-d",argv[1])==0){
      DEBUG = 1;
      objfile_name = argv[2];
    }
    else{
      printf("incorrect usage\n");
      return 1;
    }
  }
                        
  // Open file descriptor and set up memory map for objfile_name
  int fileDesc = open(objfile_name, O_RDONLY);
  
  struct stat struct1;

  fstat(fileDesc, &struct1);

  int len = struct1.st_size;
  
  char *holder = mmap(NULL, len, PROT_READ, MAP_SHARED, fileDesc, 0);


  // CREATE A POINTER to the intial bytes of the file which are an ELF64_Ehdr struct
  Elf64_Ehdr *ehdr = (Elf64_Ehdr*) holder;


  // CHECK e_ident field's bytes 0 to for for the sequence {0x7f,'E','L','F'}.
  // Exit the program with code 1 if the bytes do not match
  if(ehdr->e_ident [EI_MAG0] == 0X7F && ehdr->e_ident [EI_MAG1] == 'E' && ehdr->e_ident [EI_MAG2] == 'L' && ehdr->e_ident [EI_MAG3] == 'F')
  {
    //do nothing
  }
  else
  {
    close(fileDesc);
    munmap(holder, len);
    printf("ERROR: Magic bytes wrong, this is not an ELF file");
    return 1;
  }

  // PROVIDED: check for a 64-bit file
  if(ehdr->e_ident[EI_CLASS] != ELFCLASS64){
    printf("Not a 64-bit file ELF file\n");
    close(fileDesc);
    munmap(holder, len);
    return 1;
  }

  // PROVIDED: check for x86-64 architecture
  if(ehdr->e_machine != EM_X86_64){
    printf("Not an x86-64 file\n");
    close(fileDesc);
    munmap(holder, len);
    return 1;
  }

  // DETERMINE THE OFFSET of the Section Header Array (e_shoff), the
  // number of sections (e_shnum), and the index of the Section Header
  // String table (e_shstrndx). These fields are from the ELF File
  // Header.
  int header = ehdr->e_shoff;
  int sections = ehdr->e_shnum;
  int table = ehdr->e_shstrndx;
  // Set up a pointer to the array of section headers. Use the section
  // header string table index to find its byte position in the file
  // and set up a pointer to it.
  Elf64_Shdr *sec_hdrs = (Elf64_Shdr*) (holder + header);
  char *sec_names = (sec_hdrs[table].sh_offset + holder);
  

  // Search the Section Header Array for the secion with name .symtab
  // (symbol table) and .strtab (string table).  Note their positions
  // in the file (sh_offset field).  Also note the size in bytes
  // (sh_size) and and the size of each entry (sh_entsize) for .symtab
  // so its number of entries can be computed.
  uint64_t symOffset = -1;
  uint64_t strOffset = -1;
  uint64_t symSize = -1;
  uint64_t symEntries = -1;

  for(int i=0; i<sections; i++){
    char *secName = (sec_names + sec_hdrs[i].sh_name);
    if(strcmp(secName,".symtab") == 0)
    {
      symOffset = sec_hdrs[i].sh_offset;
      symSize = sec_hdrs[i].sh_size;
      symEntries = sec_hdrs[i].sh_entsize;
    }
    if(strcmp(secName,".strtab") == 0)
    {
      strOffset = sec_hdrs[i].sh_offset;
    }
  }

  if(symOffset == -1){
    printf("ERROR: Couldn't find symbol table\n");
    close(fileDesc);
    munmap(holder, len);
    return 1;
  }

  if(strOffset == -1){
    printf("ERROR: Couldn't find string table\n");
    close(fileDesc);
    munmap(holder, len);
    return 1;
  }

  // PRINT byte information about where the symbol table was found and
  // its sizes. The number of entries in the symbol table can be
  // determined by dividing its total size in bytes by the size of
  // each entry.
  printf("Symbol Table\n");
  printf("- %ld bytes offset from start of file\n",symOffset);
  printf("- %ld bytes total size\n",symSize);
  printf("- %ld bytes per entry\n",symEntries);
  printf("- %ld entries\n",(symSize/symEntries));


  // Set up pointers to the Symbol Table and associated String Table
  // using offsets found earlier.
  Elf64_Sym *symTab = (Elf64_Sym*) (holder + symOffset);
  char *strTab = (char*) (holder + strOffset);

  // Print column IDs for info on each symbol
  printf("[%3s]  %8s %4s %s\n",
         "idx","TYPE","SIZE","NAME");

  // Iterate over the symbol table entries
  for(int i=0; i<(symSize/symEntries); i++){
    // Determine size of symbol and name. Use <NONE> name has zero
    // length.
    uint64_t sizeOfSym = symTab[i].st_size;
    char *name = (symTab[i].st_name + strTab);
    if(strlen(name) == 0)
    {
      name = "<NONE>";
    }
    // Determine type of symbol. See assignment specification for
    // fields, macros, and definitions related to this.
    unsigned char typec = ELF64_ST_TYPE(symTab[i].st_info);
    char *typeStr = "<NONE>";
    if(typec == STT_NOTYPE)
    {
      typeStr = "NOTYPE";
    }
    else if(typec == STT_OBJECT)
    {
      typeStr = "OBJECT";
    }
    else if(typec == STT_FUNC)
    {
      typeStr = "FUNC";
    }
    else if(typec == STT_FILE)
    {
      typeStr = "FILE";
    }
    else if(typec == STT_SECTION)
    {
      typeStr = "SECTION";
    }

    // Print symbol information
    printf("[%3d]: %8s %4lu %s\n",i,typeStr,sizeOfSym,name);
  }


  // Unmap file from memory and close associated file descriptor 
  close(fileDesc);
  munmap(holder, len);
  return 0;
}
