import java.awt.*;
import javax.swing.*;
/**
 * Squirtle.java  
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class Squirtle extends Pokemon
{
    /**
    Constructs the Squirtle class
     * @param String The name
     * @param int The type (1 = fire, 2 = water, 3 = grass, 4 = normal)
     * @param int The health
     * @param int The attack
     * @param int The defence
     * @param int The SPA
     * @param int The SPD
     * @param int The Speed
     * @param Attack Attack 1
     * @param Attack Attack 2
     * @param Attack Attack 3
     * @param Attack Attack 4
     */
    public Squirtle()
    {
        super("Squirtle", 2, 44, 48, 65, 50, 64, 43, new Attack("Tackle", 40, 4, 1), new Attack("Water Gun" ,40,2,2), new Attack("Bite", 60,4,1), new Attack("Hydropump",110,2,2));
       
    }

    /**
     * Returns the image
     * @return Image The image
     */
  public Image getImage()
    {
        ImageIcon i = new ImageIcon(getClass().getResource("/images/Squirtle.png"));
        
        return i.getImage();
    }
    
    /**
     * Returns the back image
     * @return Image The back image
     */
    public Image getImageBack()
    {
        ImageIcon i = new ImageIcon(getClass().getResource("/images/squirtleBack.png"));
        return i.getImage();
    }
}
