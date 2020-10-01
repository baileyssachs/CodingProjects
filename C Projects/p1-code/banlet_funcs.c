// banlet_funcs.c: support functions for the banlet_main program.

#include "banlet.h"

// PROBLEM 1: Replace instances of character 'old' with 'new' in the
// string 'str'.  May use the strlen() library function to determine
// string length or directly look for a '\0' null termination
// character to end the string.
//
// EXAMPLES:
// char *s1="A A B B A"; string_replace_char(s1, 'A', 'X'); // s1 is "X X B B X"
// char *s2="A A B B A"; string_replace_char(s2, 'B', 'Y'); // s2 is "A A Y Y A"
// char *s3="A A B B A"; string_replace_char(s3, ' ', '-'); // s3 is "A-A-B-B-A"
void string_replace_char(char *str, char old, char new){
  for(int i = 0; i < strlen(str); i++)//loops through the string
  {
    if(str[i] == old) //checks if current char is the one we want to replace
    {
      str[i] = new;
    }
  }
}

// PROBLEM 1: Counts the number of newline characters '\n' in the
// string 'msg'; return this number +1 as the end of lines will always
// be a line break. May use the strlen() library function to determine
// string length or directly look for a '\0' null termination
// character to end the string.
//
// EXAMPLES:
// count_linebreaks("Hi")        ->  1
// count_linebreaks("Hi There")  ->  1
// count_linebreaks("Hi\nThere") ->  2
// count_linebreaks("O\nM\nG")   ->  3
int count_linebreaks(char *msg){
  int count = 1;//always atleast one
  for(int i = 0; i < (strlen(msg)); i++)
  {
    if(msg[i] == '\n')  //if char is a new line(\n) then add one
    {
      count = count + 1;
    }
  }
  return count;
}

// PROBLEM 1: Counts the linebreaks (newline '\n' chars and end of
// string) and returns an array of integers with the position for each
// linebreak in string 'msg'.  The 'nbreaks' parameter is an OUTPUT
// integer that should be set to the number of breaks in 'msg' using
// the C dereference operator (*).
//
// EXAMPLES:
// int nbreaks = -1;
// int *breaks = find_linebreaks("Hello\nWorld", &nbreaks);
// //            index in string: 012345 67890
// // nbreaks is now 2
// // breask is now [5, 11]
int *find_linebreaks(char *msg, int *nbreaks){
  *nbreaks = count_linebreaks(msg);
  if (*nbreaks <= 0)
  {
    return NULL;//if no linebreaks then just end the func and return null
  }
  int *holder = malloc(sizeof(int)*(*nbreaks));//makes array with enough spots to hold all the nbreak locations
  int count = 0;
  for(int i = 0; i < (strlen(msg)); i++)
  {
    if(msg[i] == '\n')
    {
      holder[count] = i;//if char is a newline char then add index to list
      count = count + 1;
    }
  }
  holder[count] = (strlen(msg));//adds last index to list because there is always a newline there
  return holder;

}

// PROBLEM 1: Prints string 'msg' using 'font'. Only prints characters
// 0 to 'length-1'.  Iterates over each row in font->height and then
// scans across the charactes in 'msg' printing each "row" of the
// character. On reaching index 'length', prints a newline and then
// scans across 'msg' again printing characters from the next row.
// Each msg[i] character is used to as the index into fonts->glyphs[]
// to access the "glyph" that will be printed.
//
// NOTE: This function does NOT handle embedded newline '\n'
// characters. It is intended to be called repeatedly on each line in
// multiline text with '\n' characters found using the
// 'find_linebreaks()' function.
//
// EXAMPLE:
//
// print_fontified("Hello!", 6, &font_standard);
// // Prints the following on standard output:
//  _   _        _  _         _
// | | | |  ___ | || |  ___  | |
// | |_| | / _ \| || | / _ \ | |
// |  _  ||  __/| || || (_) ||_|
// |_| |_| \___||_||_| \___/ (_)
void print_fontified(char *msg, int length, font_t *font){
  for(int i = 0; i < font->height; i++) //loops through height of font
  {
    for(int c = 0; c < length; c++)
    {
      int temp = (int)msg[c];
      printf("%s",font->glyphs[temp].data[i]);  //prints char by char to build text row by row, directly from glyph
    }
    printf("\n"); //new line after all the chars
  }
}

// PROBLEM 2: Uses print_fontified() with find_linebreaks() to
// correctly print 'msg' with 'font' even if there are linebreaks in
// 'msg'.  Uses find_linebreaks() to find the end of each line in
// 'msg' and then iterates over lines printing each.  Uses pointer
// arithmetic to pass the starting position of each line into calls of
// print_fontified(). Frees memory allocated before returning.
//
// EXAMPLE:
// print_fontified_linebreaks("apple\nB@N@N@\nCarr0^", &font_standard);
// // Shows the following on standard output:
//                       _
//   __ _  _ __   _ __  | |  ___
//  / _` || '_ \ | '_ \ | | / _ \
// | (_| || |_) || |_) || ||  __/
//  \__,_|| .__/ | .__/ |_| \___|
//        |_|    |_|
//  ____     ____   _   _    ____   _   _    ____
// | __ )   / __ \ | \ | |  / __ \ | \ | |  / __ \
// |  _ \  / / _` ||  \| | / / _` ||  \| | / / _` |
// | |_) || | (_| || |\  || | (_| || |\  || | (_| |
// |____/  \ \__,_||_| \_| \ \__,_||_| \_| \ \__,_|
//          \____/          \____/          \____/
//   ____                      ___   /\
//  / ___|  __ _  _ __  _ __  / _ \ |/\|
// | |     / _` || '__|| '__|| | | |
// | |___ | (_| || |   | |   | |_| |
//  \____| \__,_||_|   |_|    \___/
void print_fontified_linebreaks(char *msg, font_t *font){
  int b = count_linebreaks(msg);//counts all linebreaks
  int* a = find_linebreaks(msg, &b);//finds the indexs for all line breaks
  for(int i = 0; i < b; i++)//loops through all linebreak indexs
  {
    int counter = 0;
    int done = 0;
    int temp2 = 0;
    if(i > 0)
    {
      temp2 = a[i-1] + 1;
    }
    char* temp = malloc(sizeof(char)*(a[i]-temp2) );//sets size of string to current linebreak pos - last linebreak pos

    for(int c = 0; c < a[i];c++)
    {

      if(i>0 && done == 0)//if not done this loop yet then do it
      {
        c = a[i-1] + 1;//sets c equal to current pos in msg, does this because we dont want to start at 0 every time
        done = 1;//indicates this if has happened
      }
      temp[counter] = msg[c];//can do this because we set c to the proper index
      counter = counter + 1;//keeps track of how many letters added
    }
    if(i == 0)
    {
      print_fontified(temp, a[i]-temp2, font);//prints it with length of current index - prev index +1
      free(temp);
    }
    else
    {
      print_fontified(temp, a[i]-temp2, font);//prints it with length of current index - prev index +1
      free(temp);//frees temp from memory so no leaks occur
    }

    done = 0;
  }
  free(a);//frees a from memory
}

// PROVIDED: Initializes a glyph to mostly X's except for its
// codepoint on the first line.
void glyph_init(glyph_t *glyph, int codepoint){
  glyph->codepoint = codepoint;
  glyph->width = 6;
  for(int i=0; i<MAX_HEIGHT; i++){
    for(int j=0; j<MAX_WIDTH; j++){
      if(j == glyph->width){
        glyph->data[i][j] = '\0'; // null terminate
      }
      else{
        glyph->data[i][j] = 'X';
      }
    }
  }
  int len = sprintf((char *)glyph->data, "%d",codepoint); // add codepoint # to glyph
  glyph->data[0][len] = 'X';                              // remove null termination char
}

// PROBLEM 2: Loads a banner font from 'filename'.  The format of text
// file is documented more thoroughly in the project specification but
// is generally comprised of a first line that indicate the height of
// each glyph in the font followed by a sequence of each glyph
// starting with its codepoint (ASCII index) and a grid of characters
// in it. To make parsing easier, the @ character is used to represent
// blank spaces in glyph shapes.
//
// EXAMPLE:
// height: 4
// 42
// @@@
// \|/
// /|\
// @@@
// 43
// @@@
// _|_
// @|@
// @@@
//
// The two characters above are the codepoint 42 '*' and codepoint 43
// '+' with the @ symbols eventually being replaced by spaces during
// loading.
//
// If 'filename' cannot be opened for reading, returns NULL.
//
// Memory allocation happens in two steps: (1) allocates memory for a
// font_t struct then (2) allocates memory for an array of glyph_t
// structs of length NUM_ASCII_GLYPHS (a constant defined in
// banlet.h). Sets the font->glyphs field to be the allocated array of
// glyphs.  Reads the font->height field from teh first line of the
// file.  Iterates over each element of the glyphs array and calls the
// glyph_init() function on it to populate it with default data.  Then
// proceeds to read glyphs from the file. Glyphs are read by reading
// the integer codepoint first which determins which element of the
// glyph array to read into.  Then a loop over the height of the font
// is used to read each row of the glyph into the
// glyph[codepoint]->data[row]; fscanf() with '%s' specifier is used
// for this.  Finally, the string_replace_char() function is used to
// replace all '@' characters with ' ' (space) characters in the glyph
// data. Sets the width of each glyph using the strlen() function on
// any balid row of the glyph data.
//
// Glyphs are read from 'filename' until an attempt to read a glyph's
// codepoint with fscanf() returns EOF (end of file). This causes the
// routine to return the allocated font_t data for use elsewhere.
font_t *font_load(char *filename){
  FILE* read = fopen(filename, "r");//opens file
  if(read == NULL)
  {
    return NULL;//if cant read file then return null
  }
  font_t *font = malloc(sizeof(font_t));//makes room for the font struct
  font->glyphs = malloc(sizeof(glyph_t) * NUM_ASCII_GLYPHS);//makes glyph array of size ASCII(128)
  int height;
  int index;
  fscanf(read, "height: %d", &height);
  font->height = height;//sets height of font
  for(int i = 0; i < NUM_ASCII_GLYPHS; i++)
  {
    glyph_init(&font->glyphs[i], i);//initialize all glyphs to their ascii coefficient
  }
  while(fscanf(read,"%d",&index) != EOF)
  {
    for(int c = 0; c < height; c++)
    {
      fscanf(read, "%s\n", font-> glyphs[index].data[c]); //write from file into glyph
      string_replace_char(font->glyphs[index].data[c],'@', ' ');//spaces are @ when read from file so turn them back to spaces
      font->glyphs[index].width = strlen(font->glyphs[index].data[c]);//sets width of font
    }
  }
  fclose(read);//closes file
  return font;
}



// PROBLEM 2: Frees the memory associated with 'font'.  First frees
// the glyph array, then frees the font itself. Hint: this funciton
// should be 2 lines long.
void font_free(font_t *font){
    free(font->glyphs);//frees the glyph array
    free (font);//frees the struct
}
