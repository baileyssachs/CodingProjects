
/**
 * Write a description of class LLtester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LLtester
{
    public static void main(String[] args)
    {
        LinkedL LL = new LinkedL();

        LL.add(4.4);

        LL.add(2.2);

        LL.add(8.8);

        LL.add(12.2);

        LL.add(65);

        LL.add(68.9);

        System.out.println(LL);

        System.out.println("Test add(1336)");
        LL.add(1336);
        System.out.println(LL);
        System.out.println("Test isFull");
        System.out.println(LL.isFull());
        System.out.println("Test remove");
        LL.remove();
        System.out.println(LL);
        System.out.println("remove 2");
        LL.remove(2);
        System.out.println(LL);
        System.out.println(LL);
        System.out.println("Test get");
        System.out.println(LL.get());
        System.out.println("Testing size");
        System.out.println(LL.size());
        System.out.println(LL);
        System.out.println("Test clear");
        LL.clear();
        System.out.println(LL);

    }

}
