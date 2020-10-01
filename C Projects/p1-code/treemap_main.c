#include "treemap.h"
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
//main func reused from hw2 with major adjustments
int main(int argc, char *argv[]){
  int echo = 0;                                // controls echoing, 0: echo off, 1: echo on
  if(argc > 1 && strcmp("-echo",argv[1])==0) { // turn echoing on via -echo command line option
    echo=1;
  }


  printf("TreeMap Editor\n");
  printf("Commands:\n");
  printf("  quit:            exit the program\n");
  printf("  print:           shows contents of the tree in reverse sorted order\n");
  printf("  add <key> <val>: inserts the given key/val into the tree, duplicate keys are ignored\n");
  printf("  get <key>:       prints FOUND if the name is in the tree, NOT FOUND otherwise\n");
  printf("  clear:           eliminates all key/vals from the tree\n");
  printf("  preorder:        prints contents of the tree in pre-order which is how it will be saved\n");
  printf("  save <file>:     writes the contents of the tree in pre-order to the given file\n");
  printf("  load <file>:     clears the current tree and loads the one in the given file\n");

  char cmd[128];
  char holder[128]; //holds keys in methods
  char holder2[128];  //holds values in methods
  treemap_t tree;
  int success;
  treemap_init(&tree);

  while(1){
    printf("TM> ");                 // print prompt
    success = fscanf(stdin,"%s",cmd); // read a command
    if(success==EOF){                 // check for end of input
      printf("\n");                   // found end of input
      break;                          // break from loop
    }

    if( strcmp("quit", cmd)==0 ){     // check for quit command
      if(echo){
        printf("quit\n");
      }
      break;                          // break from loop
    }

    else if( strcmp("print", cmd)==0 ){
      if(echo==1){
        printf("print\n");
      }
        treemap_print_revorder(&tree);
      }


    else if( strcmp("add", cmd)==0 ){     // add command
      fscanf(stdin,"%s",holder); //key
      fscanf(stdin,"%s",holder2); //value
      if(echo == 1){
        printf("add %s %s\n",holder, holder2);
      }
      int x = treemap_add(&tree, holder, holder2);
      if(x == 0)//key already existed and we just changed val
      {
        printf("modified existing key\n");
      }
    }

    else if( strcmp("get", cmd)==0 ){     // get command
      fscanf(stdin,"%s",holder);          // read a key
      if(echo == 1){
        printf("get %s \n",holder);
      }

      char *ith = treemap_get(&tree, holder); // call list function
      if(ith == NULL){                    // check for success
        printf("NOT FOUND \n");
      }
      else {
        printf("FOUND: %s \n",ith);
      }
    }

    else if( strcmp("clear", cmd)==0 ){   // clear command
      if(echo == 1){
        printf("clear\n");
      }
      treemap_clear(&tree);
    }

    else if( strcmp("preorder", cmd)==0 ){   // print preorder command
      if(echo == 1){
        printf("preorder\n");
      }
      treemap_print_preorder(&tree);
    }

    else if( strcmp("save", cmd)==0 ){   // save command
      fscanf(stdin,"%s",holder);
      if(echo == 1){
        printf("save %s\n", holder);
      }
      treemap_save(&tree, holder);
    }

    else if( strcmp("load", cmd)==0 ){   // load command
      fscanf(stdin,"%s",holder);
      if(echo == 1){
        printf("load %s\n",holder);
      }
      int x = treemap_load(&tree, holder);
      if(x == 0)  //file didnt open
      {
        printf("ERROR: could not open file '%s'\n", holder);
        printf("load failed\n");
      }
    }

    // add case for "contains" command which uses the list_contains() function

    else{                                 // unknown command
      if(echo){
        printf("%s\n",cmd);
      }
      printf("unknown command %s\n",cmd);

    }


}  // end main while loop
  treemap_clear(&tree);                      // clean up the list
  return 0;
}
