import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
/**
 * Player.java  
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class Player extends GlobalPosition
{
    private String playerImage = "/images/Player.png/";
    private double velX = 0;
    private double velY = 0;
    public Player(int x, int y)
    {
        super(x,y);
    }

    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_RIGHT)
        {
            velX = .5;
        }
        else if (key == KeyEvent.VK_LEFT)
        {
            velX = -.5;
        }
       else if (key == KeyEvent.VK_DOWN)
        {
            velY = .5;
        }
        else if (key == KeyEvent.VK_UP)
        {
            velY = -.5;
        }
        
    }
    
    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_RIGHT)
        {
            velX = 0;
        }
        else if (key == KeyEvent.VK_LEFT)
        {
            velX = 0;
        }
        else if (key == KeyEvent.VK_DOWN)
        {
            velY = 0;
        }
        else if (key == KeyEvent.VK_UP)
        {
            velY = 0;
        }
    }
    
    public void update()
    {
       x+=velX;
       y+=velY;
       
       if(x < 1)
       {
           x = 1;
        }
        else if(x > 428)
        {
            x = 428;
        }
        else if(y < 1)
        {
            y = 1;
        }
        else if(y > 379)
        {
            y = 379;
        }
    }

    public void draw(Graphics2D g2d)
    {
        g2d.drawImage(getPlayerImage(),x,y,null);
    }
    
    public Image getPlayerImage()
    {
        ImageIcon i = new ImageIcon(getClass().getResource(playerImage));
        return i.getImage();
    }
}