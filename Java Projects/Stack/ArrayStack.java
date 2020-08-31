
/**
 * Write a description of class Stack here.
 *
 * Marissa Garfinkle
 * @version (a version number or a date)
 */
 
public class ArrayStack<T> implements StackInterface<T>
{
    private T[] a;
    private int size;
    public ArrayStack()
    {
        a = (T[])new Object[0];
        size = 0;
    }
    
    public int size()
    {
      return size;
    }   
    
   
    public boolean empty()
    {
      if(size == 0)
      {
          return true;
      }
      else
        return false;
    }
    
 
    public T peek() throws StackUnderflowException
    {
        if(!empty())
       {
          return a[size-1];
       }
       else
       {
          try{
           throw new StackUnderflowException();    
         }
          catch(StackUnderflowException e)
         {
           System.out.println(e.toString()); 
        }
        return null;
       }
    }
    
   
    public T pop() throws StackUnderflowException
    {
        if(!empty())
        {
           T temp2 = a[size-1];
           T[] temp = (T[])new Object[size-1];
           for(int i = 0; i < size-1; i++)
           {
              temp[i] = a[i];
           }
           a = temp;
           size--;
           return temp2;
        }
         else
       {
          try{
           throw new StackUnderflowException();    
         }
          catch(StackUnderflowException e)
         {
           System.out.println(e.toString()); 
        }
        return null;
       }
    }
    
    public T push(T item)
    {
       T[] temp = (T[])new Object[size+1];
       for(int i = 0; i < size(); i++)
       {
           temp[i] = a[i];
       }
       temp[size] = item;
       a = temp;
       size++;
       return item;
    }
        
    
    public void clear()
    {
       T[] c = (T[]) new Object[4];
       a = c;
       size = 0;
    }
    

       public int search(Object o)
    {
        int i = size() - 1;        
        int n = 1;               
        while (i >= 0) {
            T temp = a[i];
            if(o.equals(temp))
            {
                return n;
            }
            i--;
            n++;
        }
        return -1;
    }
    }


