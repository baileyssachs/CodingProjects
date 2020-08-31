import java.awt.*;
import javax.swing.*;
/**
 * Bulbasaur.java  
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class Bulbasaur extends Pokemon
{
    /**
     * Constructs the Bulbasaur class
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
    public Bulbasaur()
    {
        super("Bulbasaur", 3, 45, 49, 49, 65, 65, 45, new Attack("Tackle", 40, 4, 1), new Attack("Vine Whip",45,3,1), new Attack("Take Down", 80,4,1), new Attack("Solar Beam",120,3,2));
        
    }
    
    /**
     * Returns the Image
     * @returns Image The image
     */
      public Image getImage()
    {
        ImageIcon i = new ImageIcon(getClass().getResource("/images/Bulbasaur.jpg"));
        
        return i.getImage();
    }
    
    /**
     * Returns the image
     * @returns Image The back image
     */
    public Image getImageBack()
    {
        ImageIcon i = new ImageIcon(getClass().getResource("/images/bulbasaurBack.png"));
        return i.getImage();
    }
}
