import java.awt.*;
import javax.swing.*;
/**
 * Charmander.java  
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class Charmander extends Pokemon
{
    /**
     * Constructs the Charmander class
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
    public Charmander()
    {

        super("Charmander", 1, 39, 52, 43, 60, 50, 65, new Attack("Slash", 75, 4, 1), new Attack("Fire Fang", 65,1,1), new Attack("Flamethrower", 90,1,2), new Attack("Inferno",100,1,2));
        
    }

    /**
     * Returns the image
     * @return Image The image
     */
    public Image getImage()
    {
        ImageIcon i = new ImageIcon(getClass().getResource("/images/Charmander.png"));
        
        return i.getImage();
    }
    
    /**
     * Returns the back image
     * @return Image The back image
     */
    public Image getImageBack()
    {
        ImageIcon i = new ImageIcon(getClass().getResource("/images/charmanderBack.png"));
        return i.getImage();
    }
}
