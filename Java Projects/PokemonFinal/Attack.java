
/**
 * Attack.java  
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class Attack
{
    private String name;
    private int damage;
    private int type;  //Special or physical 1 for Physical 2 for special 
    private int typeOfAttack;
    /**
     * Constructs the Attack class
     * @param String Name of the attack
     * @param int Damage dealt
     * @param int Type 1 = fire, 2 = water, 3 = grass, 4 = normal
     * @param int Type of attack 1 = Physical, 2 = Special
     */
    public Attack(String n, int d, int t, int tp)
    {
        name = n;
        damage = d; 
        type = t;
        typeOfAttack = tp;
    }
    
    /**
     * Returns 1 for Fire, 2 for Water, 3 for Grass, 4 for normal
     * @return int Type
     */
    public int getType()
    {
        return type;
    }
    
    /**
     * 1 for physical 2 for special
     * @return int Type of attack
     */
    public int getTypeOfAttack()
    {
        return typeOfAttack;
    }
    
    /**
     * Returns Damage
     * @return int Damage
     */
    public int getDamage()
    {
        return damage;
    }
    
    /**
     * Return name
     * @return String Name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Return a string representation of the class
     * @return String A string representation of the class
     */
    public String toString()
    {
        return getName() + " Attack: " +getDamage();
    }
}
