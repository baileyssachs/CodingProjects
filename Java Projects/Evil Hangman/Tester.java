import java.io.FileNotFoundException;
/**
 * Tester.java 
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */

public class Tester
{
   public static void main(String[] args) throws FileNotFoundException
   {
       EvilHangman evil = new EvilHangman(true);
       
       System.out.println("TESTING getPattern");
       System.out.println(evil.getPattern("ALLY", "L"));
       System.out.println("EXPECTED: -LL-\n");
       System.out.println(evil.getPattern("ALLY", "B"));
       System.out.println("EXPECTED: ----\n");
       
       System.out.println("TESTING getPatterns");
       System.out.println(evil.getPatterns("E"));
       System.out.println("EXPECTED: ----, -E--, --E-, E--E, ---E\n");

       System.out.println("TESTING getPartitions");
       System.out.println(evil.getPartitions(evil.getPatterns("E"), "E"));
       System.out.println("EXPECTED: [ALLY, COOL, GOOD], [BETA, DEAL], [ELSE], [FLEW, IBEX], [HOPE]\n");
       
       System.out.println("TESTING getLargestRemaining");
       System.out.println(evil.getLargestRemaining(evil.getPartitions(evil.getPatterns("E"), "E")));
       System.out.println("EXPECTED: [ALLY, COOL, GOOD]\n");
       
       System.out.println("TESTING substitute");
       evil.substitute("BETA", "E");
       System.out.println(evil.getSolution());
       System.out.println("EXPECTED: -E--");
       
       evil.substitute("BETA", "A");
       System.out.println(evil.getSolution());
       System.out.println("EXPECTED: -E-A");
       
       evil.substitute("BETA", "G");
       System.out.println(evil.getSolution());
       System.out.println("EXPECTED: -E-A\n\n");
       
       EvilHangman evil2 = new EvilHangman(false);
       evil2.playGame();
   }
}
