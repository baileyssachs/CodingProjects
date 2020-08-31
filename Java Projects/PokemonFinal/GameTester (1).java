
import javax.swing.JFrame;


/**
 * GameTester.java  
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class GameTester
{
    public static void Main(String args[]) 
    {
        JFrame frame = new JFrame();

        frame.setSize(450,405);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Game());
        frame.setVisible(true);
        
    }

   
}
