import java.awt.*;
/**
 * TeleportingStalker.java  
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class TeleportingStalker extends StalkerEnemy
{
    private int count;
    public TeleportingStalker(int x, int y, int w, int h, Rectangle p)
    {
        super(x,y,w,h,p);
    }
    
    public boolean test()
    {
        return true;
    }
    
    public Color getColor()
    {
        return new Color(192,192,192);
    }
    
    public void move()
    {
        count++;
        if(count % 10 == 0)
        {
        Rectangle rect = getRectangle();
        rect.x = (int)(Math.random() * 600);
        rect.y = (int)(Math.random() * 600);
        }
    }
}
