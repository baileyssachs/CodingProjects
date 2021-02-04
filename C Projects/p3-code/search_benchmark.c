#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>
#include <error.h>
#include <time.h>
#include <unistd.h>
#include "search.h" 
// Complete this main to benchmark the search algorithms outlined in
// the project specification
int main(int argc, char *argv[]){
  int do_linear;
  int do_binary;
  int do_linked;
  int do_tree;
  if(argc == 1)
  {
    printf("usage: ./search_benchmark <minpow> <maxpow> <repeats> [which]\n"
    "which is a combination of:\n"
    " a : Linear Array Search\n"
    " l : Linked List Search\n"
    " b : Binary Array Search\n"
    " t : Binary Tree Search\n"
    " (default all)\n");
    return 0;
  }
   printf("%8s ","Length");         //printing header
   printf("%8s ","searches");       //printing header
  
  if(argc > 4)    //if user inputted a 4th argument to function
  {
    do_linear = 0;
    do_binary = 0;
    do_linked = 0;
    do_tree = 0;
    if(strstr(argv[4],"a") != NULL) //if string contains an a
    {
      do_linear = 1;
      printf("%10s ","array");      //printing header
    }
    if(strstr(argv[4],"l") != NULL)   //if string contains an l
    {
      do_linked = 1;
      printf("%10s ","list");       //printing header
    }
    if(strstr(argv[4],"b") != NULL) //if string contains an b
    {
      do_binary = 1;
      printf("%10s ","binary");     //printing header
    }
    if(strstr(argv[4],"t") != NULL) //if string contains an t
    {
      do_tree = 1;
      printf("%10s ","tree");     //printing header
    }
  }
  else  //no string inputted as 4th arg so make all of them true
  {
    do_linear = 1;
    do_binary = 1;
    do_linked = 1;
    do_tree = 1;  
    printf("%10s ","array");      //printing header
    printf("%10s ","list");       //printing header
    printf("%10s ","binary");     //printing header
    printf("%10s ","tree");       //printing header
  }
  printf("\n");

  int min = atoi(argv[1]);      //converting string to int
  int max = atoi(argv[2]);      //converting string to int
  int repeats = atol(argv[3]);  //converting string to int
  int powmin = 2 << (min -1);   //raising 2 to the power of min - 1
  int powmax = 2 << max;        //raising 2 to the power of max
  
  for(int i = powmin; i < powmax; i*=2)     //times equaling by 2 so I don't have to use pow each iteration
  {
    printf("%8d ",i); //printing the length
    int searches = repeats * (i * 2);
    printf("%8d ",searches); //printing the nummber of seaches.
    clock_t begin, end; //making the two clock_t instances in memory
    if(do_linear)                 //if user selected do_linear go into if
    {
      int *temp = make_evens_array(i);                  // setup array
      begin = clock();                                  // start timer
      for(int c = 0; c < repeats; c++)
      {
        for(int z = 1; z < ((2*i)-1); z++)
        {                                             //loop from 1 - size*2 -1
          linear_array_search(temp,i,z);              // do searches
        }
      }
      end = clock();                                        // stop timer
      double cpu_time_linear = ((double) (end - begin)) / CLOCKS_PER_SEC;
      printf("%10.4e ",cpu_time_linear);        //prints out real time how long it took
      free(temp);     //free the array
    }
    if(do_linked) //if user selected do_linked go into if
    {
      list_t *temp = make_evens_list(i);                  // setup array
      begin = clock();                                  // start timer
      for(int c = 0; c < repeats; c++)
      {
        for(int z = 1; z < ((2*i)-1); z++)
        {                                             //loop from 1 - size*2 -1
          linkedlist_search(temp,i,z);              // do searches
        }
      }
      end = clock();                                        // stop timer
      double cpu_time_linked = ((double) (end - begin)) / CLOCKS_PER_SEC;
      printf("%10.4e ",cpu_time_linked);      //prints out real time how long it took
      list_free(temp);                       //free the list_t struct
    }
    if(do_binary)                             //if user selected do_binary go into if
    {
      int *temp = make_evens_array(i);                  // setup array
      begin = clock();                                  // start timer
      for(int c = 0; c < repeats; c++)
      {
        for(int z = 1; z < ((2*i)-1); z++)
        {                                             //loop from 1 - size*2 -1
          binary_array_search(temp,i,z);              // do searches
        }
      }
      end = clock();                                        // stop timer
      double cpu_time_binary = ((double) (end - begin)) / CLOCKS_PER_SEC;  
      printf("%10.4e ",cpu_time_binary);              //prints out real time how long it took
      free(temp);                                         //free the array
    }
    if(do_tree)
    {
      bst_t *temp = make_evens_tree(i);                  // setup array
      begin = clock();                                  // start timer
      for(int c = 0; c < repeats; c++)
      {
        for(int z = 1; z < ((2*i)-1); z++)
        {                                             //loop from 1 - size*2 -1
          binary_tree_search(temp,i,z);              // do searches
        }
      }
      end = clock();                                        // stop timer
      double cpu_time_tree = ((double) (end - begin)) / CLOCKS_PER_SEC;
      printf("%10.4e ",cpu_time_tree);                    //prints out real time how long it took 
      bst_free(temp);                                         //free the array
    }
    printf("\n");           //prints a new line for formatting
    
  }

  return 0; //returns 0 when done successfully.
}


