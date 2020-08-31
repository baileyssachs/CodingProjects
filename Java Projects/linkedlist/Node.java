
/**
 * Node.java  
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * defines a Blueprint for creating nodes to be used in a linked list
 *
 */
public class Node
{
    double value;
    Node next;
    
    public Node(double v, Node n)
    {
        value = v;
        next = n;
    }
    public Node()
    {
        value = 0;
        
    }
    
}
