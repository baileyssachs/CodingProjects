import java.util.Scanner;
/**
 * FizzBuzz.java 
 *
 * @author: Bailey Sachs
 * Assignment #: FizzBuzz
 * 
 * Brief Program Description:
 * Counts from 1-100 but
 * on multiples of 3 prints out fizz
 * on multiples of 5 prints out buzz
 * and on multiples of 3 and 5 prints out fizzbuzz
 *
 */

public class FizzBuzz 
{
    public static void main(String[] args)
    {
        int a = -1;
        int b = -1;
        Scanner sc = new Scanner(System.in);
        while(a < 0)
        {
            System.out.println("Please type in the minimum number");
            a = sc.nextInt();
        }
        while(b < 0)
        {
            System.out.println("Please enter the maximum number.");
            b = sc.nextInt();
            while(b <= a)
            {
                System.out.println("Please select a number higher than the first.");
                b = sc.nextInt();
            }
        }
        System.out.println("");
        FizzOrBuzz(a, b);
    }
    
    /**
     * Counts from a to b and prints out fizz on multiples of 3, buzz on multiples of 5
     * and fizzbuzz on multiples of 3 and 5
     * @param int a, starting numver
     * @param int b, ending number
     */
    public static void FizzOrBuzz(int a, int b)
    {
        for(int x = a; x <= b; x++)
        {
            if(x % 3 == 0)
            {
                System.out.print("Fizz");
                if(x % 5 == 0)
                {
                    System.out.print("Buzz");
                }
                else
                {
                    System.out.println();
                }
            }
            else if(x % 5 == 0)
            {
                System.out.println("Buzz");
            }
            else
            {
                System.out.println(x);
            }
        }
    }
}

// Please type in the minimum number
// 1
// Please enter the maximum number.
// 75

// 1
// 2
// Fizz
// 4
// Buzz
// Fizz
// 7
// 8
// Fizz
// Buzz
// 11
// Fizz
// 13
// 14
// FizzBuzz16
// 17
// Fizz
// 19
// Buzz
// Fizz
// 22
// 23
// Fizz
// Buzz
// 26
// Fizz
// 28
// 29
// FizzBuzz31
// 32
// Fizz
// 34
// Buzz
// Fizz
// 37
// 38
// Fizz
// Buzz
// 41
// Fizz
// 43
// 44
// FizzBuzz46
// 47
// Fizz
// 49
// Buzz
// Fizz
// 52
// 53
// Fizz
// Buzz
// 56
// Fizz
// 58
// 59
// FizzBuzz61
// 62
// Fizz
// 64
// Buzz
// Fizz
// 67
// 68
// Fizz
// Buzz
// 71
// Fizz
// 73
// 74
// FizzBuzz