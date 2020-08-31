
/**
 * SqureMatrixInterface.java 
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public interface SquareMatrixInterface
{
    public int getSize();
    public void setValue(int a, int b, int c);
    public int getValue(int a, int b);
    public void fillValue(int a);
    public void makeZero();
    public String toString();
    public SquareMatrix add(SquareMatrix a);
    public SquareMatrix subtract(SquareMatrix a);
    public SquareMatrix copy();
}
