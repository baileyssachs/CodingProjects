import java.io.*;
/**
 * WordCount.java  
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class WordCount implements Comparable<WordCount>, Serializable
{
    String a;
    int b;
    public WordCount(String word)
    {  
       a = word;
       b = 1;
    }
    
    public String getWord()
    {
        return a;
    }
    
    public int getCount()
    {
        return b;
    }
    
    public void increment()
    {
        b++;
    }
    
    public String toString()
    {
        return "Test " + b;
    }
    
    public boolean equals(WordCount other)
    {
        if(a.equals(other.getWord()))
        {
            return true;
        }
        return false;
    }
    
    public int compareTo(WordCount other)
    {
        return other.getCount() - b;
    }
}
