/**
 * This class represents the Euclidean algoritm for calculating
 * the Greatest Common Divisor of two integers, using both recursive
 * and iterative solutions.
 * 
 * @author 
 * @version 
 */
public class Euclidean
{
    public static int gcdRecursive(int m, int n)
    {
        if(m < n)
        {
            int temp = m;
            m = n;
            n = temp;
        }
        
        if(m % n == 0)
        {
            return n;
        }
        else
        {
            return gcdRecursive(n,m%n);
        }
    }

    public static int gcdIterative(int m, int n)
    {
        if(m < n)
        {
            int temp = m;
            m = n;
            n = temp;
        }
        
        for(int i = 0; i < m; i++)
        {
            if(m % n == 0)
            {
                return n;
            }
            else
            {
                int temp = n;
                n = m % n;
                m = temp;
                
            }
            
        }
        return n;
    }
}
