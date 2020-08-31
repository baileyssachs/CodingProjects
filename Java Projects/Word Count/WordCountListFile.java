import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
/**
 * 
 */
public class WordCountListFile implements Serializable
{

    /**
     * Constructor for objects of class WordCountListFile
     */
    public WordCountListFile()
    {
    }

    public static void save(WordCountList list, String fileName) throws Exception{

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
        out.writeObject(list);
        out.close();

    }
    public static WordCountList load(String fileName) throws Exception{

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
        WordCountList l = (WordCountList)in.readObject();
        in.close();
        return l;
    }
}
