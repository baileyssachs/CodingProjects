
/**
 * LinkedL.java  
 *
 * @author: Bailey Sachs
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *This class will implement the linkedlist interface
 *
 *
 *Implement: add(value), remove(), get(), clear(), toString
 *make a tester to test them
 */
public class LinkedL implements LinkedList
{
    private int size;
    Node root;
    public LinkedL()
    {
        size = 0;
        root = null; 
    }

    public boolean add(double v)
    {
        if(root == null)
        {
            root = new Node(v, null);
            return true;
        }
        Node temp = root;
        while(temp.next != null)
        {
            temp = temp.next;
        }
        temp.next = new Node(v, null);

        size ++;
        return true;
    }

    public boolean add(double value, int pos)
    {
        return false;
    }

    //removes the last node in the list
    public boolean remove()
    {
        Node temp = root;
        //temp = null;
        for(int i = 0; i < size -2; i++)
        {
            temp = temp.next;
        }
        temp.next = new Node(temp.next.value, null);
        size --;
        return true;
    }

    public boolean isFull()
    {
        return false;
    }

    public double remove(int pos)
    {
        Node temp = root;
        int i = 0;
        while(i < size)
        {
            if(i != pos - 1)
            {
                temp = temp.next;
            }
            else
            {
                double a = temp.next.value;
                temp.next = temp.next.next;
                return a;
            }
            i++;
        }
        return -1;
    }

    public double remove(double value)
    {
        for(int i = 0; i < size - 1; i++)
        {
            if(root.value == value)
            {
                double a = root.value;
                remove(i);
                size--;
                return a;    
            }
            root = root.next;
        }
        return -1;
    }


    public double get()
    {
        Node t = root;
        while (t.next != null)
        {
            t = t.next;
        }
        return t.value;
    }

    public double get(int pos)
    {
        return 0.0;
    }

    public void clear()
    {
        Node t = root;
        t = null;
        while(t != null)
        {
            t = new Node(0, null);

            t = t.next;
        }

        size = 0;
        root = t;
    }

    public void reverse()
    {
    }

    public int size()
    {
        return size;
    }

    public String toString()
    {

        Node r = root;
        String print = "Contents: ";
        while(r != null)
        {
            print += r.value + " ";
            r = r.next;
        }

        return print;
    }
}

