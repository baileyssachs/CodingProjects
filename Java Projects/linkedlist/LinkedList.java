
/**
 * LinkedList.java  
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *This interface will outline the functionality of a LinkeList
 */
public interface LinkedList
{
    /**
     * This should add the value to the end of the LL
     */
    public boolean add(double value);
    
    /**
     * Adds the value to the given pos
     */
    public boolean add(double value, int pos);
    
    /**
     * removes the last node in the list
     */
    public boolean remove();
    
    /**
     * Removes a specific value from the LL and returns it
     */
    public double remove(double value);
    
    /**
     * Removes the value at the given pos. and returns it
     */    
    public double remove(int pos);
    
    /**
     * Gets the last element but does NOT remove it
     */
    public double get();
    
    /**
     * gets the value at the given position
     */
    public double get(int pos);
    
    /**
     * clears the list
     */
    public void clear();
    
    /**
     * reverses the list(Stretch)
     */
    public void reverse();
    
    /**
     * Returns the number of elements stored in the list
     */
    public int size();
    
    /**
     * returns if the list is full?
     */
    public boolean isFull();
    
    /**
     * returns a string representation of the LL
     */
    public String toString();
}
