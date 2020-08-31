import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//    written by helge393 and sachs096
public class Hash<T extends Comparable<T>>{
    private Node[] hashTable = new Node[109];

    public void add(T item)
    {
        if(containsKey(item) == true)    //checks to make sure duplicates aren't added
        {
            return;
        }
        int x = hash(item);
        if(hashTable[x] == null)
        {
            hashTable[x] = new Node(item);    //adds new value in empty space
        }
        else
        {
            hashTable[x] = new Node(item, hashTable[x]);    //adds new item to beginning of chain
        }
    }

    public boolean containsKey(T item) {
        for (int i = 0; i < hashTable.length; i++)
        {
            if(hashTable[i] != null) {
                Node temp = hashTable[i];
                if (temp.getData().equals(item)) {// checks if beginning of chain is equal to item
                    return true;
                }
                while (temp.getNext() != null) {
                    temp = temp.getNext();
                    if (temp.getData().equals(item)) {  //checks if any item in chain is equal to item
                        return true;
                    }
                }
            }

        }
        return false;
    }

    public void display()
    {
        //variable for count of unused spaces, chain size of maximum, and chain size of minimum
        int unused = 0;
        int max = -1;
        int min = 1000000;
        for(int i = 0; i < hashTable.length; i++)
        {
            int x = 1;
            if(hashTable[i] == null)
            {
                System.out.println("index: " + i + ", # linked: 0");  //prints for empty space in hash table
                unused++;
                min = 0;  //smallest chain length is zero
            }
            else {
                Node temp = hashTable[i];
                while (temp.getNext() != null) {

                    temp = temp.getNext();
                    x++;    //counts how many nodes are in chain
                }
                //checks for max and min values for chain length
                if (x > max) {
                    max = x;
                }
                if (x < min) {
                    min = x;
                }

                System.out.println("index: " + i + ", # linked: " + x);    //prints out how many nodes are linked at each index
            }
        }
        //prints values for smallest chain, biggest chain, and unused spaces
        System.out.println("biggest chain length: " + max);
        System.out.println("smallest chain length: " + min);
        System.out.println("number of unused spots: " + unused);
    }
    private int hash(T key)
    {
        //temp converts the key to a string, as all hash tables being created are using strings
        String temp = (String)key;
        int sum = 0;    //will use character values to sum up and mod by size of hash table
        for(int i = 0; i < temp.length(); i++)
        {
            sum += (temp.charAt(i) + 50);  //adding 50 weights based on the length of the words to hopefully disperse better
            // sum += (temp.charAt(i) + Math.pow(5,i));
            // alternate solution that was worse than current
            //this would make each letter a higher weight based on the length of the word.
        }

        int hashed = sum % 109;   //this will ensure a valid index is returned
        return hashed;
    }

    public static void main(String[] args)
    {
        Hash a = new Hash();
        Scanner readFile = null;
        String s;
        int count = 0;
        args = new String[5];
        args[0] = "proverbs.txt";
        System.out.println();
        System.out.println("Attempting to read from file: " + args[0]);
        try {
            readFile = new Scanner(new File(args[0]));
        }
        catch (FileNotFoundException e) {
            System.out.println("File: " + args[0] + " not found");
            System.exit(1);
        }

        System.out.println("Connection to file: " + args[0] + " successful");
        System.out.println();
        while (readFile.hasNext()) {
            s = readFile.next();
            a.add(s);

        }
        a.display();
    }
}