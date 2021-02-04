// optimized versions of matrix diagonal summing
#include "matvec.h"

int matsquare_VER1(matrix_t mat, matrix_t matsq) {

  for(int i=0; i<mat.rows; i++){
    for(int j=0; j<mat.cols; j++){
      MSET(matsq,i,j,0);                          // initialize to 0s
    }
  }
  int head; int head2; int head3; int cur; int cur2; int new; int new2;
  int head4; int head5; int cur3; int cur4; int new3; int new4; int k;    //making space for each outside so it doenst have to make speace each time
  for(int i=0; i<mat.rows; i++){
    for(int j=0; j<mat.cols; j++){
      head = MGET(mat, i, j);
      k = 0;
      for(; k<mat.cols-3; k+=4){  //goes by 4 so we can loop unroll effectivly
        head2 = MGET(mat, j, k);  //does it in this order to fully utilize superscalar processor
        cur = MGET(matsq, i, k);
        new = cur + head*head2;
        MSET(matsq, i, k, new);
        head3 = MGET(mat, j, k+1);
        cur2 = MGET(matsq, i, k+1);
        new2 = cur2 + head*head3;
        MSET(matsq, i, k+1, new2);
        head4 = MGET(mat, j, k+2);
        cur3 = MGET(matsq, i, k+2);
        new3 = cur3 + head*head4;
        MSET(matsq, i, k+2, new3);
        head5 = MGET(mat, j, k+3);
        cur4 = MGET(matsq, i, k+3);
        new4 = cur4 + head*head5;
        MSET(matsq, i, k+3, new4);
      }
      for(; k < mat.cols; k++)  //loop that goes through the rest of the numbers if the number of columns isnt perftly divisible by 4
      {
        head2 = MGET(mat, j, k);
        cur = MGET(matsq, i, k);
        new = cur + head*head2;
        MSET(matsq, i, k, new);
      }
    }
  }
  return 0; //returns 0 when done successfully
}


int matsquare_OPTM(matrix_t mat, matrix_t matsq) {
  if(mat.rows != mat.cols ||                       // must be a square matrix to square it
     mat.rows != matsq.rows || mat.cols != matsq.cols)
  {
    printf("matsquare_OPTM: dimension mismatch\n");
    return 1;
  }


  // Call to some version of optimized code
  return matsquare_VER1(mat, matsq);
}
