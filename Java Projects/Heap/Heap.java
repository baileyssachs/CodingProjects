import java.util.*;
/**
 * Write a description of class Heap here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Heap<T extends Comparable<T>> implements PriorityQueue<T> 
{
    private ArrayList<T> elements;
    private int lastIndex;
    private int size;
    public Heap()
    {
        elements = new ArrayList<T>();
        lastIndex = -1;
        size = 0;
    }

    // returns the logical size of the priority queue
    public int size()
    {
        return size;
    }

    // tests if this priority queue is empty
    public boolean empty()
    {
        return (lastIndex == -1);
    }

    // adds an item to the priority queue
    public T add(T element)
    {
        lastIndex++;
        size++;
        elements.add(lastIndex, element);
        reheapUp(element);
        return element;
    }

    private void reheapUp(T element)
    {
        int hole = lastIndex;
        while ((hole > 0) && (element.compareTo(elements.get((hole - 1)/(2))) > 0))
        {
            elements.set(hole, elements.get((hole - 1)/2));
            hole = (hole - 1)/2;
        }
        elements.set(hole, element);
    }

    // looks at the object at the front of this priority queue
    // without removing it from the priority queue
    public T peek() throws PQUnderflowException
    {
        if (empty())
        {
            throw new PQUnderflowException("This Priority Queue is Empty!");   
        } else
        {
            return elements.get(0);
        }
    }

    // removes the object at the front of this priority queue 
    // and returns that object as the value of this function
    public T remove() throws PQUnderflowException
    {
        T temp;
        T move;

        if (lastIndex == -1)
        {
            throw new PQUnderflowException("This Priority Queue is Empty!!");
        } else
        {
            temp = elements.get(0);
            move = elements.remove(lastIndex);
            lastIndex--;
            size--;
            if (lastIndex != -1)
            {
                reheapDown(move);   
            }
            return temp;
        }
    }

    private void reheapDown(T element)
    {
        int hole = 0;
        int hole2;

        hole2 = hole2(hole, element);
        while (hole2 != hole)
        {
            elements.set(hole, elements.get(hole2));
            hole = hole2;
            hole2 = hole2(hole, element);
        }
        elements.set(hole, element);
    }

    private int hole2(int hole, T element)
    {
        int left = (hole * 2) + 1;
        int right = (hole * 2) + 2;

        if (left > lastIndex)
        {
            return hole;   
        } else if (left == lastIndex)
        {
            if (element.compareTo(elements.get(left)) < 0)  
            {
                return left;
            } else
            {
                return hole;   
            }
        } else if (elements.get(left).compareTo(elements.get(right)) < 0)
        {
            if (elements.get(right).compareTo(element) <= 0)
            {
                return hole; 
            } else
            {
                return right;   
            }
        } else if (elements.get(left).compareTo(element) <= 0)
        {
            return hole;   
        } else
        {
            return left;   
        }

    }

    // removes all of the elements from this priority queue
    public void clear()
    {
        for (int i = 0; i >= elements.size(); i--)
        {
            elements.set(i, null);
        }
        size=0;
        lastIndex=-1;
    }
}
