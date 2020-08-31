
/**
 * This LinkedStringLog object represents a StringLog ADT implemented as
 * a LinkedList using the EnhancedStringLogInterface.
 * 
 * @author Bailey Sachs
 */
public class LinkedStringLog implements EnhancedStringLogInterface
{
    private LLStringNode log;
    private String name;
    private int size;

    public LinkedStringLog(String name)
    {
        this.name = name;
        size = 0;
        log = null;
    }

    // returns the name of this StringLog
    public String getName()
    {
        return name;
    }

    // returns the logical size of this StringLog
    public int size()
    {
        return size;
    }

    // returns true if this list contains no elements
    public boolean isEmpty()
    {
        // if(log == null)
        // {
        // return true;
        // }
        // else
        // {
        // return false;
        // }
        return size == 0;
    }

    // returns true if this list is completely full
    public boolean isFull()
    {
        return false;
    }

    // appends the specified element to the end of this list
    public void add(String element)
    {
        if(log == null)
        {
            log = new LLStringNode(element); 
            size ++;
        }
        else
        {
            LLStringNode temp1 = log;//its not a list so you are just using temp to get to the last element in the LL then adding an element to that
            while(temp1.getLink() != null)
            {
                temp1 = temp1.getLink();
            }

            LLStringNode temp2 = new LLStringNode(element);
            temp1.setLink(temp2); 
            size ++;
        }
    }

    // returns the element at the specified position in this list
    public String get(int index)
    {
        LLStringNode temp = log;
        for(int i = 0; i < index; i++)
        {
            temp = temp.getLink();
        }
        return temp.getInfo();

    }

    // returns the index of the first occurance of the specified element
    // in this list, or -1 if this list does not contain the element
    public int indexOf(String element)
    {
        LLStringNode temp = log;
        int i = 0;
        while(temp != null)
        {
            if(temp.getInfo().equals(element))
            {
                return i;
            }
            temp = temp.getLink();
            i++;

        }
        return -1;
    }

    // returns true if this list contains the specified element
    public boolean contains(String element)
    {
        LLStringNode temp = log; 
        while(temp != null)
        {
            if(temp.getInfo().equals(element))
            {
                return true;
            }
            temp = temp.getLink();

        }
        return false;
    }

    // returns a formatted string representation of this StringLog
    public String toString()
    {
        String result = "Log: " + name + "\n";
        LLStringNode curNode = log;
        int count = 0;

        while (curNode != null)
        {
            count++;
            result += count + ". " + curNode.getInfo() + "\n";
            curNode = curNode.getLink();
        }
        return result;
    }

    // replaces the element at the specified position in this list
    // with the specified element
    public String set(int index, String element)
    {

        LLStringNode temp = log;
        for(int i = 0; i < index ; i++)
        {
            temp = temp.getLink();
        }
        String re = temp.getInfo();

        temp.setInfo(element);
        return re;

    }
    // inserts the specified element at the specified position in this list
    public void add(int index, String element)
    {
        size += 1;
        LLStringNode  n = new LLStringNode(element);

        LLStringNode cur = log;

        for(int i = 0; i < index-1; i++)
        {

            cur = cur.getLink();

        }
        n.setLink(cur.getLink());
        cur.setLink(n);

    }

    // removes the element at the specified position in this list
    public String remove(int index)
    {
        LLStringNode cur = log;
        if(index == 0)
        {
            String temp = log.getInfo();
            log = log.getLink();
            size--;
            return temp;
        }
        else
        {
            for(int i = 0; i < index - 1; i++)
            {
                cur = cur.getLink();
            }

            String temp = cur.getLink().getInfo();

            cur.setLink(cur.getLink().getLink());

            size--;
            return temp;
        }
    }

    // removes the first occurance of the specified element from this
    // list, if it is present
    public boolean remove(String element)
    {
        LLStringNode cur = log;
        if(cur.getInfo().equals(element))
        {
            log = log.getLink();
            size--;
            return true;
        }
        while(cur.getLink().getLink() != null)

        {
            if(cur.getLink().getInfo().equals(element))
            {
                cur.setLink(cur.getLink().getLink());
                size--;
                return true;
            }
            cur = cur.getLink();

        }
        if(cur.getLink().getInfo().equals(element))
        {
            cur.setLink(cur.getLink().getLink());
            size--;
            return true;
        }
        return false;

    }


    // removes all of the elements from this list
    public void clear()
    {
        log.setLink(null);
        size =0;
    }
}
