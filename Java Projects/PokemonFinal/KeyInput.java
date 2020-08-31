import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/**
 * KeyInput.java  
 *
 * @author: Bailey and Noah
 * 
 * Brief Program Description:
 * This class is needed for action listeners and is the action listener foundation
 *
 */
public class KeyInput extends KeyAdapter
{
    Player p;
    public KeyInput(Player p)
    {
        this.p = p;
    }
    
    public void keyPressed(KeyEvent e)
    {
        p.keyPressed(e);
    }
    
    public void keyReleased(KeyEvent e)
    {
        p.keyReleased(e);
    }
}
