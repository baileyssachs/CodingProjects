import java.io.*;
/**
 * WordCountList.java  
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class WordCountList implements Serializable
{
    WordCount[] a = new WordCount[4];
    int size = 0;
    public int size()
    {
        return size;
    }

    public void add(String word)
    {
        if(size == a.length)
        {
            WordCount[] abc = new WordCount[size * 2];
            for(int i = 0; i < size; i++)
            {
                abc[i] = a[i];
            }
            a = abc;
        }
        WordCount test = new WordCount(word);
        Boolean done = false;
        for(int i = 0; i < size; i++)
        {
            if(a[i].equals(test))
            {
                a[i].increment();
                done = true;
            }
        }
        if(done == false)
        {
            a[size] = test;
            size++;
        }
    }

    public WordCount get(int index)
    {
        return a[index];
    }

    public void rank()
    {
        for(int i = 0; i < size-1; i++)
        {
            int min = i;
            for(int j = i+1; j < size; j++)
            {
                if(a[j].getCount() > a[min].getCount())
                {
                    min = j;
                }
            }
            WordCount temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        } 
        if(size > 10)
        {
            for(int i = 0; i < 10; i++)
            {
                System.out.println(a[i].getWord()+ ", " + a[i].getCount());
            }
        }
        else
        {
            for(int i = 0; i < size; i++)
            {
                System.out.println(a[i].getWord() + ", " + a[i].getCount());
            }
        }
    }
}
