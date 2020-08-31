
/**
 * This LinkedQueue object represents a Queue ADT implemented as
 * a LinkedList using the QueueInterface.
 * 
 * @author Mr. Bredemeier
 * @version November 4, 2012
 */
public class LinkedQueue<T> implements QueueInterface<T>
{
    private LLNode<T> front;
    private LLNode<T> rear;
    private int size;

    public LinkedQueue()
    {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    // returns the logical size of the queue
    public int size()    
    {
        return size;
    }

    // tests if this queue is empty
    public boolean empty()
    {
        return (size == 0);
    }

    // adds an item into the rear of this queue
    public T add(T item)
    {
        LLNode<T> newNode = new LLNode<T>(item);
        if(rear == null)
            front = newNode;
        else
            rear.setLink(newNode);
        rear = newNode;
        size ++;
        return item;
    }

    // looks at the object at the front of this queue
    // without removing it from the queue
    public T peek()
    {
        if (size < 1)
            throw new QueueUnderflowException();
        return front.getInfo();
    }

    // removes the object at the front of this queue
    // and returns that object as the value of this function
    public T remove()
    {
        if(size < 1)
            throw new QueueUnderflowException();
        T result = peek();
        front = front.getLink();
        if(front == null)
            rear = null;
        size --;
        return result;
    }

    // removes all of the elements from this queue
    public void clear()
    {
        front = null;
        rear = null;
        size = 0;
    }
}
