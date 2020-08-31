

/**
 * This KeyedLinkedList object represents a Keyed List ADT implemented as
 * a LinkedList.
 * 
 * @author Bailey Sachs
 * @version
 */
public class KeyedLinkedList<K,V> implements KeyedLinkedListInterface<K,V>
{
    private KeyNode first;
    private int size = 0;
    /**
     * a private inner class that represents a doubly 
     * linked-list node that contains both a key and a value
     */
    private class KeyNode
    {
        K key;
        V value;
        KeyNode previous;
        KeyNode next;

        public KeyNode(K key, V value, KeyNode previous, KeyNode next)
        {
            this.key = key;
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }
    /**
     * returns the logical size of this list
     */
    public int size()
    {
        return size;
    }

    /**
     * if key found, update value and return false (nothing added), 
     * otherwise grow list and return true
     */
    public boolean put(K key, V value)
    {
        if(first == null){
            first = new KeyNode(key,value, null,null);
            size++;
            return true;
        }
        KeyNode n = first;
        while(n !=null){
            if(n.key.equals(key)){
                n.value = value;
                return false;
            }
            else{
                if(n.next == null){
                    KeyNode kn = new KeyNode(key,value, n, null);
                    n.next = kn;
                    size++;
                    return true;
                }
                n = n.next;
            }
        }
        return false;   
    }

    /**
     * search for key, return associated value
     * if key not found, return null
     */
    public V get(K key)
    {
        KeyNode n = first;
        if(first == null){
            return null;
        }
        while(n != null){
            if(n.key.equals(key)){
                return n.value;
            }
            n = n.next;
        }
        return null;
    }

    // removes the element at the specified key location in this list
    // return true if remove was successful, false if key not found
    public boolean remove(K key)
    {
        if(first == null){
            return false;
        }
        if(first.next == null){
            first = null;
            size--;
            return true;
        }
        KeyNode n = first;
        while(n!=null){
            if(n.key.equals(key)){
                if(n.previous == null){
                    first = first.next;
                    first.previous = null;
                    size--;
                    return true;
                }
                if(n.next == null)
                {
                    first = first.previous;
                    
                    size--;
                    return true;
                }
                n.previous.next = n.next;
                
                n.next.previous = n.previous;
                size--;
                return true;
            }
            n = n.next;
        }
        return false; 
    }
}