
/**
 * Tester.java 
 *
 * @author:Bailey Sachs
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */

public class Tester 
{
   public static void main(String[] args)
   {
       GameOfLife a = new GameOfLife(8,8);
       a.growCellAt(4,6);
       a.growCellAt(4,7);
       a.growCellAt(7,7);
       a.growCellAt(4,0);
       a.growCellAt(0,0);
       a.growCellAt(0,7);
       a.growCellAt(7,0);
       a.growCellAt(2,2);
       a.growCellAt(2,3);
       a.growCellAt(2,1);
       a.growCellAt(3,3);
       a.growCellAt(0,6);
       a.growCellAt(7,6);
       a.growCellAt(1,6);
       System.out.println(a.toString());
       System.out.println(a.neighborCount(6,4));
       System.out.println(a.neighborCount(0,0));
       System.out.println(a.neighborCount(2,2));
       System.out.println(a.neighborCount(4,0));
       System.out.println(a.neighborCount(0,6));
   }
}
