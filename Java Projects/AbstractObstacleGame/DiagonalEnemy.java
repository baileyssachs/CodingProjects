import java.awt.*;

public class DiagonalEnemy extends VerticalEnemy
{
    private int screenWidth;
    private int xSpeed;
    public DiagonalEnemy(int x, int y, int w, int h, int sH, int yS, int sW, int xS) {
        super(x,y,w,h,sH,yS);
        xSpeed = xS;
        screenWidth = sW;
    }

    public boolean test()
    {
        return false;
    }

    public Color getColor()
    {
        return new Color(25,185,92);
    }

    public void move()
    {
        super.move();
        Rectangle rect = getRectangle();
        rect.x += xSpeed;
        if(rect.x + rect.width >= screenWidth || rect.x <= 0)
        {
            xSpeed *= -1;
        }
    }

}