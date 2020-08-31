/**
 * This HashTable object represents a hash table ADT implemented as an array of doubly linked lists
 * 
 * @author  
 * @version 
 */
public class HashTable<K,V> implements HashTableInterface<K,V>
{
    private int size;
    private int capacity;
    private KeyedLinkedList<K,V> [] table;

    @SuppressWarnings("unchecked")
    public HashTable(int capacity)
    {
        table = (KeyedLinkedList<K,V>[]) new KeyedLinkedList[capacity];
        size = 0;
        this.capacity = capacity;
        for(int i = 0; i < capacity; i++)
        {
            table[i] = new KeyedLinkedList();
        }
    }

    // returns the number of keys in this hashtable
    public int size()
    {
        return size;  // complete this method
    }

    // clears this hashtable so that it contains no keys
    @SuppressWarnings("unchecked")
    public void clear()
    {
        // complete this method
        for(int i = 0; i < capacity; i++)
        {
            table[i] = new KeyedLinkedList();
        }
        size = 0;
        // it is essentially identical to the constructor
    }

    // returns the hashtable index for a given key
    public int hashIndex(K key)
    {
        // the line below insures a positive integer by eliminating the sign bit
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    // if key found, update value and return false (nothing added), 
    // otherwise grow table and return true
    public boolean put(K key, V value)
    {      
        KeyedLinkedList<K,V> list = table[hashIndex(key)];
        if(list.put(key,value))
        {
            size++;
            return true;
        }
           return false;
    }
    
    // search for key, return associated value
    // if key not found, return null
    public V get(K key)
    {
        KeyedLinkedList<K,V> list = table[hashIndex(key)];
        return list.get(key);    // complete this method
    }

    // removes the element at the specified key location in this table
    // return true if remove was successful, false if key not found
    public boolean remove(K key)
    {
        KeyedLinkedList<K,V> list = table[hashIndex(key)];
        if(list.remove(key))
        {
            size--;
            return true;
        }
        return false;
    }
}
