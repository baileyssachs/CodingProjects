
/**
 * Rotate.java  
 *
 * @author:Bailey Sachs
 * Assignment #:rotate 2d array
 * 
 * Brief Program Description:
 * rotates a 2d array clockwise
 *
 */
public class Rotate
{
    public static int[][] rotateArray(int[][] a)
    {
        int x = a.length;
        int y = a[0].length;
        int[][] temp = new int[y][x];
        for(int r = 0; r < x; r++)
        {
            for(int c = 0; c < y; c++)
            {
                temp[c][x-1-r] = a[r][c];
            }
        }
        return temp;
    }
}
// Now attempting to rotate the following 7x7 array
// 
// 	9	3	3	4	7	8	1
// 	9	5	9	9	2	6	2
// 	0	9	4	7	6	9	6
// 	8	2	2	6	4	0	8
// 	3	4	6	4	3	6	1
// 	0	6	3	2	2	9	7
// 	7	0	8	0	4	7	9
// 
// Good.  Here is your properly rotated array
// 
// 	7	0	3	8	0	9	9
// 	0	6	4	2	9	5	3
// 	8	3	6	2	4	9	3
// 	0	2	4	6	7	9	4
// 	4	2	3	4	6	2	7
// 	7	9	6	0	9	6	8
// 	9	7	1	8	6	2	1
// 
// 
// Congratulations!  You have completed the Rotate assignment
