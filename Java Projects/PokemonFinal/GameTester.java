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
        
            Game g = new Game();
            if(g.getPlayer().getRoomNum() == 0)
            {
                g.getFrame().setSize(450,405);
            }
            else if(g.getPlayer().getRoomNum() >= 1)
            {
                g.getFrame().setSize(384,640);
            }
            g.getFrame().setResizable(false);
            g.getFrame().setLocationRelativeTo(null);
            g.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            g.getFrame().add(g);
            g.getFrame().setVisible(true);
    }
}
