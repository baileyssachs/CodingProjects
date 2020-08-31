
/**
 * GlobalPosition.java  
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class GlobalPosition
{
    public int x;
    public int y;
     
    /**
     * Controls the player's position
     * @param int The player's x cordinant
     * @param int The player's y cordinant
     */
   
    public GlobalPosition(int xz, int yz)
    {
        x = xz;
        y = yz;
    }
    
    /**
     * Moves the player
     * @param int Where the x cordinant should be moved
     * @param int Where the y cordinant should be moved
     */
    public void move(int a, int b)
    {
        x=a;
        y=b;
    }
}