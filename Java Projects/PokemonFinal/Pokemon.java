import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
/**
 * Pokemon.java  
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class Pokemon
{
    //1 is fire, 2 is water, 3 is grass. Strings are abnoxious
    private String name;
    private int startHP;
    private int type;

    private int exp;
    private int health;
    private int attack;
    private int defence; 
    private int spAttack;
    private int spDefence;
    private int speed;
    //private Pokemon temp;
    private Attack a1;
    private Attack a2;
    private Attack a3;
    private Attack a4;
    /**
     * Constructs the pokemon class
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
    public Pokemon(String n, int t,  int h,int a,int d,int sa,int sd,int sp, Attack w, Attack x, Attack y, Attack z)
    {

        name = n;
        startHP = h;

        health = h;
        attack = a;

        type = t;
        defence = d; 
        spAttack = sa;
        spDefence = sd;
        speed = sp;
        a1 = w;
        a2 = x;
        a3 = y;
        a4 = z;

        //For posible status effect moves (ie lowering attack or defence
        //temp = new Pokemon(n,t,l,health,attack,defence,spAttack, spDefence, speed, a1, a2,a3,a4);
    }

    /**
     * Returns name
     * @returns String Name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Returns back image
     * @returns Image Back image
     */
    public Image getImageBack()
    {
        return null;
    }
    
    /**
     * Sets the name of the pokemon
     * @param String Name
     */
    public void setName(String n)
    {
        name = n;
    }

   
    /**
     * Returns type
     * @returns int Type
     */
    public int getType()
    {
        return type;
    }

    public void heal()
    {
        health = startHP;
    }

    /**
     *  Returns image
     * @returns Image Image
     */
    public Image getImage()
    {
        return null;
    }

    //if we want to make moves with status effects, I can explain my idea for that
    //     /**
    //      * Resets stats after a battle
    //      */
    //     public void resetStats()
    //     {
    //         health = temp.getHealth();
    //         attack = temp.getAttack();
    //         spAttack = temp.getSPAttack();
    //         defence = temp.getDefence();
    //         spDefence = temp.getSPDefence();
    //         speed = temp.getSpeed();
    //     }
    //     public Image getImage()
    //     {
    //         ImageIcon i = new ImageIcon(getClass().getResource("/images/"+name+".jpg"));
    //         
    //         return i.getImage();
    //     }

    /**
     *  Returns start HP
     * @returns int Start HP
     */
    public int getStartHP()
    {
        return startHP;
    }


    /**
     *  Returns HP
     * @returns int HP
     */
    public int getHealth()
    {
        return health;
    }

    /**
     * Sets Health
     * @param int Health
     */
    public void setHealth(int h)
    {
        health = h;
    }

    /**
     *  Returns attack
     * @returns int attack
     */
    public int getAttack()
    {
        return attack;
    }

    /**
     * Sets attack
     * @param int Attack
     */
    public void setAttack(int a)
    {
        attack = a;
    }

    /**
     *  Returns def
     * @returns int def
     */
    public int getDefence(){
        return defence;
    }

    /**
     *    Sets def
     * @param int def
     */
    public void setDefence(int d)
    {
        defence = d;
    }

    /**\
     * 
     *  Returns spa
     * @returns int spa
     */
     
    public int getSPAttack()
    {
        return spAttack;
    }

    /**
     *     Sets spa
     * @param int spa
     */
    public void setSPAttack(int s)
    {
        spAttack = s;
    }

    /**
     * Returns spd
     * @return int spd
     */
    public int getSPDefence()
    {
        return spDefence;
    }

    /**
     *     Sets spd
     * @param int spd
     */
    public void setSPDefence(int d)
    {
        spDefence = d;
    }

    /**
     * Returns speed
     * @returns int Speed
     */
    public int getSpeed()
    {
        return speed;
    }

    /**
     * Changes a move
     * @param int Which move should be changed
     * @param Attack What the move is being changed to
     */
    public void setMove(int i, Attack temp)
    {
        if(i==1)
        {
            a1 = temp;
        }
        else if(i==2)
        {
            a2 = temp;
        }
        else if(i==3)
        {
            a3 = temp;
        }
        else if(i==4)
        {
            a4 = temp;
        }
    }

    /**
     * Returns moveset
     * @return Attack[] Moveset
     */
    public Attack[] getMoveSet()
    {
        Attack[] a = new Attack[4];
        a[0] = a1;
        a[1] = a2;
        a[2] = a3;
        a[3] = a4;
        return a;
    }

    /**
     * sets speed
     * @param int Speed
     */
    public void setSpeed(int s)
    {
        speed = s;
    }


    /**
     * Calculates the attack
     * @param int Which attack is being used
     * @param String The oponent's type
     * @param int The oponent's defence
     * @param int The oponent's special defence
     * @returns int The amount of damage dealt
     */
    public int getAttack(int i, int opType, int def, int spDef)
    {
        Attack temp = new Attack(null, 0,0,0);
        double mod = 1;

        if(i == 1){
            temp =  a1;
        }
        else if(i == 2){
            temp = a2;
        }
        else if(i == 3){
            temp = a3;
        }
        else if(i == 4){
            temp = a4;
        }

        if(temp.getType() == 2 && opType == 1)
        {
            mod = 2;
        }

        else if(temp.getType() == 3 && opType == 2)
        {
            mod = 2;
        }
        else if(temp.getType() == 1 && opType == 3)
        {
            mod = 2;
        }

        else if(temp.getType() == 1 && opType == 2)
        {
            mod = .5;
        }
        else if(temp.getType() == 2 && opType == 3)
        {
            mod = .5;
        }
        else if(temp.getType() == 3 && opType == 1)
        {
            mod = .5;
        }
        mod *= 1 - (((int)(Math.random() + 25))/100);

        if(temp.getTypeOfAttack() == 1)
        {
            return (int)(((((((2 * 10)/5)+2) * temp.getDamage() * attack/def)/50)+2)*mod);
        }
        else
        {
            return (int)(((((((2 * 10)/5)+2) * temp.getDamage() * spAttack/spDef)/50)+2)*mod);
        }
    }

    /**
     * Returns a string representation of the class
     * @returns String a string representation of the class
     */
    public String toString()
    {
        return "Pokemon: " + name + ", Health: " + health + ", Attack 1: " + a1.getName() + ", Attack 2: " + a2.getName() + ", Attack 3: " + a3.getName() + ", Attack 4: " + a4.getName();
    }
}
