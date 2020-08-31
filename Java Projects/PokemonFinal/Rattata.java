import java.awt.*;
import javax.swing.*;
/**
 * Rattata.java  
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class Rattata extends Pokemon
{
    /**
     * Constructs the Rattata class
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
    public Rattata()
    {
        super("Rattata", 4, 30, 56, 35, 25, 35, 72, new Attack("Tackle", 40, 4, 1), new Attack("Bite",60,4,1), new Attack("Hyper Fang", 80,4,1), new Attack("Crunch",90,4,1));
        
    }

    /**
     * Returns the image
     * @return Image The image
     */
    public Image getImage()
    {
        ImageIcon i = new ImageIcon(getClass().getResource("/images/Rattata.png"));
        
        return i.getImage();
    }
    
}
