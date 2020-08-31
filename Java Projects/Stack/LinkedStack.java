
/**
 * Write a description of class LinkedStack here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LinkedStack<T> implements StackInterface<T>
{
    int size;
    LLNode<T> log;
    public LinkedStack()
    {
        size = 0;
        log = null;
    }
    // returns the logical size of the stack
    public int size()
    {
        return size;
    }

    // tests if this stack is empty
    public boolean empty()
    {
        if(size == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    // looks at the object at the top of this stack
    // without removing it from the stack
    public T peek() throws StackUnderflowException
    {
        if(!empty())
        {
            LLNode temp = log;
            while(temp.getLink() != null)
            {
                temp = temp.getLink();
            }
            return (T)temp.getInfo();
        }
        else
        {

            throw new StackUnderflowException();    

        }
    }

    // removes the object at the top of this stack 
    // and returns that object as the value of this function
    public T pop() throws StackUnderflowException
    {
        if(empty())
        {
            
                throw new StackUnderflowException();    
            
        }
        else if(size == 1)
        {
            T re = log.getInfo();
            log = null;
            size = 0;
            return re;
        }
        else
        {
            LLNode temp = log;

            while(temp.getLink().getLink() != null)
            {
                temp = temp.getLink();
            }
            T re = (T)temp.getLink().getInfo();
            temp.setLink(null);
            size --;

            return re;
            
        }
    }

    // pushes an item onto the top of this stack
    public T push(T item)
    {
        if(size == 0)
        {
            log = new LLNode<T>(item);
            size++;
            return item;
        }
        else
        {
            LLNode<T> temp = log;
            int i = 0;
            while(temp.getLink() != null && i < size -1)
            {
                temp = temp.getLink();
                i++;
            }
            LLNode<T> temp2 = new LLNode<T>(item);
            temp.setLink(temp2);
            size ++;
            return item;
        }
    }

    // removes all of the elements from this stack
    public void clear()
    {
        log = null;
        size = 0;
    }

    // returns the 1 based position where an object is on this stack
    // note: when the method ends, the stack is the same as it was at the start
    public int search(Object o)
    {
        LLNode<T> temp = log;
        int i = 0;
        while(temp.getLink() != null)
        {
            Object hi = (T)temp.getInfo();
            if(o.equals(hi))
            {
                return size - i;
            }
      
            i = i + 1;
            temp = temp.getLink();
        }
        Object hi = (T)temp.getInfo();
        if(o.equals(hi))
            {
                return size - i;
            }
        
        return -1;
    }

}
