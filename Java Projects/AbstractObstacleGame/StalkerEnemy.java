import java.awt.*;

public class StalkerEnemy extends Enemy
{
    private Rectangle playerRectangle;
    public StalkerEnemy(int x, int y, int w, int h, Rectangle p) {
        super(x,y,w,h);
        playerRectangle = p;
    }
    
    public Color getColor()
    {
        return new Color(192,62,183);
    }
    
    public boolean test()
    {
        return false;
    }
    
    public void move()
    {
        Rectangle enemyRect = getRectangle();
        if(enemyRect.x < playerRectangle.x)
        {
            enemyRect.x += 1;
        }
        else
        {
            enemyRect.x -= 1;
        }
        
        if(enemyRect.y < playerRectangle.y)
        {
            enemyRect.y += 1;
        }
        else
        {
            enemyRect.y -= 1;
        }
    }

}