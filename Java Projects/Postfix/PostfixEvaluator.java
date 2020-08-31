import java.util.Stack;
import java.util.Scanner;
/**
 * Write a description of class PostfixEvaluator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PostfixEvaluator
{

    public static int evaluate(String expression) throws PostfixException
    {
        Stack a = new Stack<Integer>();
        Scanner sc = new Scanner(expression);
        try
        {
            if(expression.length() < 2 && expression.contains("+") || expression.contains("-")||expression.contains("*")||expression.contains("/"))
            {
                throw new PostfixException(); 
            }
        }
        catch(Exception e)
        {

        }
        while(sc.hasNext())
        {
            if(sc.hasNextInt())
            {
                a.push(sc.nextInt());
            }
            else
            {
                try
                {
                    if(a.size() < 2)
                    {
                        throw new PostfixException();
                    }
                    int y = (Integer)a.pop();
                    int x = (Integer)a.pop();
                    String temp = sc.next();

                    if(temp.equals("+"))
                    {
                        a.push(x + y);
                    }
                    else if(temp.equals("-"))
                    {
                        a.push(x - y);
                    }
                    else if(temp.equals("*"))
                    {
                        a.push(x * y);
                    }
                    else if(temp.equals("/"))
                    {
                        a.push(x / y);
                    }

                }
                catch(Exception e)
                {
                    throw new PostfixException();
                }
            }
            if(a.size() > 2)
            {
                expression = expression.substring(1);
            }
        }
        if(a.size() >1)
        {
          throw new PostfixException(); 
        }
        int abc = (int)a.pop();
        a.clear();
        return abc;
    }

}
