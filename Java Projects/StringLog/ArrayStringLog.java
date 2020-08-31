
/**
 * This ArrayStringLog object represents a StringLog ADT implemented as
 * a String array using the EnhancedStringLogInterface.
 * 
 * @author  Bailey Sachs
 * @version 
 */
public class ArrayStringLog implements EnhancedStringLogInterface
{
    // Instance variables
    private String[] log;
    private String name;
    private int size;

    // Create a new String array with a capacity of 4 elements
    // and assign values to instance variables.
    public ArrayStringLog(String name)
    {
        this.name = name;
        log = new String[4];
        size = 0;
    }

    // Returns the name of this StringLog.
    public String getName()
    {
        return name;
    }

    // Returns the logical size of this StringLog.
    public int size()
    {
        return size;
    }

    // Returns true if this list contains no elements.
    public boolean isEmpty()
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

    // Returns true if this list is completely full.
    public boolean isFull()
    {
        if(size == log.length)
        {
            return true;
        }
        else
        {
            return false;

        }
    }

    // Appends the specified element to the end of this list.
    public void add(String element)
    {
        if(isFull())
        {
            String[] temp = new String[log.length * 2];
            for(int i = 0; i < log.length; i++)
            {
                temp[i] = log[i];
            }
            temp[log.length] = element;
            log = temp;
            size++;
        }
        else
        {
            for(int i = 0; i < log.length; i++)
            {
                if(log[i] == null)
                {
                    log[i] = element;
                    size++;
                    return;
                }
            }
        }
    }

    // Returns the element at the specified position in this list.
    public String get(int index)
    {

        return log[index];

    }

    // Returns the index of the first occurance of the specified element
    // in this list, or -1 if this list does not contain the element.
    public int indexOf(String element)
    {
        for(int i = 0; i < size; i++)
        {
            if(log[i].equals(element))
            {
                return i;
            }
        }
        return -1;
    }

    // Returns true if this list contains the specified element.
    public boolean contains(String element)
    {
        for(int i =0; i < size; i++)
        {
            if(log[i].equals(element))
            {
                return true;
            }
        }
        return false;
    }

    // Returns a formatted string representation of this StringLog.
    public String toString()
    {
        String result = "Log: " + name + "\n";
        for (int i = 0; i < size; i++)
        {
            result += (i + 1) + ". " + log[i] + "\n";
        }
        return result;
    }

    // Replaces the element at the specified position in this list
    // with the specified element.  Returns what was at that location
    public String set(int index, String element)
    {
        String temp = log[index];
        log[index] = element;
        return temp;
    }

    // Inserts the specified element at the specified position in this list.
    public void add(int index, String element)
    {

        if(log[index] == null)
        {
            log[index] = element;
        }
        else
        {
            if(isFull())
            {
                String[] temp = new String[log.length * 2];
                for(int i = 0; i < index; i++)
                {
                    temp[i] = log[i];
                }
                temp[index] = element;
                for(int i = index; i < log.length; i++)
                {
                    temp[i + 1] = log[i];
                }
                log = temp;
                size++;
            }
            else
            {
                String[] temp = new String[log.length];
                for(int i = 0; i < index; i++)
                {
                    temp[i] = log[i];
                }
                temp[index] = element;
                for(int i = index + 1; i < log.length; i++)
                {
                    temp[i] = log[i - 1];
                }
                log = temp;
                size++;
            }
        }
    }

    // Removes the element at the specified position in this list, and
    // returns the element that was removed.  Any unused array elements
    // are set to null.
    public String remove(int index)
    {
        if (size < log.length / 2) {
            String[] newArray = new String[log.length / 2];
            for (int i = 0; i < log.length / 2; i++) {
                newArray[i] = log[i];

            }
            log = newArray;
        }
        String temp1 = log[index]; 
        String[] temp = new String[log.length];
        for(int i = 0; i < index; i++)
        {
            temp[i] = log[i];
        }
        for(int i = index; i < size; i++)
        {
            temp[i] = log[i + 1];
        }
        log = temp;
        size--;

        return temp1;
    }

    // Removes the first occurance of the specified element from this
    // list, if it is present.  Returns true if element was found (and 
    // removed), false otherwise.
    public boolean remove(String element)
    {

        for(int i = 0; i < size; i++)
        {
            if(log[i].equals(element))
            {
                this.remove(i);
                return true;

            }
        }
        return false;
    }

    // Removes all of the elements from this list.
    public void clear()
    {
        for(int i = 0; i < size; i++)
        {
            log[i] = null;

        }
        size = 0;
    }
}
