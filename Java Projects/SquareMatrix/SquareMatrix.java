
/**
 * SqureMatrix.java  
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class SquareMatrix implements SquareMatrixInterface
{
    int[][] parameter;

    public SquareMatrix(int n)
    {
        parameter = new int[n][n];   
    }

    public SquareMatrix(int[][] a)
    {
        parameter = a;
    }

    public int getSize()
    {
        return parameter.length;
    }

    public void setValue(int a, int b, int c)
    {
        parameter[a][b] = c;
    }

    public int getValue(int a, int b)
    {
        return parameter[a][b];
    }

    public void fillValue(int a)
    {
        for(int i = 0; i < parameter.length; i++)
        {
            for(int c = 0; c < parameter[0].length; c++)
            {
                parameter[i][c] = a;
            }
        }
    }

    public void makeZero()
    {
        for(int i = 0; i < parameter.length; i++)
        {
            for(int c = 0; c < parameter[0].length; c++)
            {
                parameter[i][c] = 0;
            }
        }
    }

    public String toString()
    {
        String temp = "";
        for(int i = 0; i < parameter.length; i++)
        {
            for(int c = 0; c < parameter[0].length; c++)
            {
                temp += parameter[i][c];
            }
            temp += "\n";
        }
        return temp;
    }

    public SquareMatrix add(SquareMatrix a)
    {
        SquareMatrix temp = new SquareMatrix(parameter);
        for(int i = 0; i < parameter.length; i++)
        {
            for(int c = 0; c < parameter[0].length; c++)
            {
                temp.setValue(i,c,parameter[i][c] + a.getValue(i,c));
            }
        }
        return temp;
    }

    public SquareMatrix subtract(SquareMatrix a)
    {
        SquareMatrix temp = new SquareMatrix(parameter);
        for(int i = 0; i < parameter.length; i++)
        {
            for(int c = 0; c < parameter[0].length; c++)
            {
                temp.setValue(i,c,parameter[i][c] - a.getValue(i,c));
            }
        }
        return temp;
    }

    public SquareMatrix copy()
    {
        SquareMatrix temp = new SquareMatrix(parameter.length);
        for(int i = 0; i < parameter.length; i++)
        {
            for(int c = 0; c < parameter[0].length; c++)
            {
                temp.setValue(i,c,parameter[i][c]);
            }
        }
        return temp;
    }
}
