import java.awt.*;

public class VerticalEnemy extends Enemy
{
    private int ySpeed;
    private int screenHeight;
    public VerticalEnemy(int x, int y, int w, int h, int sH, int yS) {
        super(x,y,w,h);
        ySpeed = yS;
        screenHeight = sH;
    }

    public boolean test()
    {
        return false;
    }

    public Color getColor()
    {
        return new Color(150, 150, 150);
    }

    public void move()
    {
        Rectangle rect = getRectangle();
        rect.y += ySpeed;
        if(rect.y + rect.height >= screenHeight || rect.y <= 0)
        {
            ySpeed *= -1;
        }
    }
}