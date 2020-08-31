
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 * Player.java  
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class Player extends GlobalPosition
{
    private String playerImage = "/images/herod1.png/";
    private double velX = 0;
    private double velY = 0;
    private boolean up, down, left, right, A;
    public static int roomNum = -1;
    private int count = -1;
    private Game1 bat;
    private Pokemon u = new Charmander();
    private JFrame game;

    /**
     * Constructs the player class
     * @param int The x cordinant
     * @param int The y cordinant
     * @param JFrame The JFrame
     */
    public Player(int x, int y, JFrame g)
    {
        super(x,y);
        Pokemon temp = new Pokemon("", 0,0,0,0,0,0,0,null,null,null,null); 
        int temp1 =(int)(Math.random() *4);

        if(temp1 == 0)
        {
            temp = new Charmander();
        }
        else if(temp1 == 1)
        {
            temp = new Squirtle();
        }
        else if(temp1 == 2)
        {
            temp = new Bulbasaur();
        }
        else if(temp1 == 3)
        {
            temp = new Rattata();
        }
        game = g;
        bat = new Game1(u, temp, game); 

        roomNum++;
    }

    /**
     * Reads the key pressed
     * @param KeyEvent The key event
     */
    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            up = true;

        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            down = true;

        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            left = true;

        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            right = true;

        }
        else if(e.getKeyCode() == KeyEvent.VK_A)
        {
            A = true;
        }
    }

    /**
     * Reads the key Released
     * @param KeyEvent The key event
     */
    public void keyReleased(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            up = false;

        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            down = false;

        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            left = false;

        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            right = false;

        }
        else if(e.getKeyCode() == KeyEvent.VK_A)
        {
            A = false;

        }
    }

    /**
     * The dialogue
     * @param int The 
     */
    public void Dialogue(int a) 
    {
        if(a == 1)
        {
            JOptionPane.showMessageDialog(null, "Hiya! Welcome to Pokemon!");
            JOptionPane.showMessageDialog(null, "Made by Noah and Bailey!");
        }
        else if(a == 2)
        {
            JOptionPane.showMessageDialog(null, "Hey, you need to head to Veridian City to fight the gym leader!");
            JOptionPane.showMessageDialog(null, "Head forward and keep going north! You can't miss it!");
        }
        else if(a == 3)
        {
            JOptionPane.showMessageDialog(null, "Hello child, with me you can name your pokemon, do you want to do that?");
            Object[] options = {"Yes", "No"};

            int red = JOptionPane.showOptionDialog(null, "Give your pokemon a nickname?", "Nickname", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, null);
            if(red == 0)
            {
                String name = JOptionPane.showInputDialog("Name");
                u.setName(name);
            }

        }
        else if(a == 4)
        {
            JOptionPane.showMessageDialog(null, "Greetings! My name is Proffesor Oak! I will now give you your pokemon! You can choose out of these three.");
            Object[] options1 = {"Charmander", "Squirtle", "Bulbasaur"};
            int red = JOptionPane.showOptionDialog(null, "Which Pokemon do you want?", "Pokemon", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options1, null);
            if(red == 1)
            {
                bat.setPokemon(new Squirtle());
            }
            else if(red == 2)
            {
                bat.setPokemon(new Bulbasaur());
            }
            JOptionPane.showMessageDialog(null, "Excellent choice! Now your pokemon journey begins! Head to Veridian city, but watch out for wild pokemon!");
        }
    }

    public void encounter()
    {
        if((int)(Math.random() * 200) == 1 && (up || down || left || right))
        {
            up = false;
            down = false;
            left = false;
            right = false;
            bat.battle();

            bat.getFrame().dispose();
            bat.healPokemon();
            Pokemon temp = new Pokemon("", 0,0,0,0,0,0,0,null,null,null,null); 
            int temp1 =(int)(Math.random() *4);
            if(temp1 == 0)
            {
                temp = new Charmander();
            }
            else if(temp1 == 1)
            {
                temp = new Squirtle();
            }
            else if(temp1 == 2)
            {
                temp = new Bulbasaur();
            }
            else if(temp1 == 3)
            {
                temp = new Rattata();
            }
            bat.setPokemonEnemy(temp);
        }
    }

    public void update()
    {

        if(up) {
            y-=1;
            playerImage = "/images/herou1.png/";
        }
        if(down) {
            y+=1;
            playerImage = "/images/herod1.png/";
        }
        if(left) {
            x-=1;
            playerImage = "/images/herol1.png/";
        }
        if(right) {
            x+=1;
            playerImage = "/images/heror1.png/";
        }
        if(roomNum == 0)
        {
            if(count < 0)
            {
                x = 225;
                y = 385;
                count++;
            }
            if(x < 23)
            {
                x = 23;
            }
            else if(x > 408)
            {
                x = 408;
            }
            else if(y < 45)
            {
                if(!(x >= 179 && x <= 222))
                {

                    y = 45;
                }
            }
            else if(y > 349)
            {
                y = 349;
            }
            //top left house
            else if(y == 137  && up)
            {
                if((x > 65 && x < 114) && (x > 131 && x < 170))
                {
                    y++;
                }
            }
            //People 
            if(x > 179 && x < 215 && y < 299 && y > 255 && A)
            {
                up = false;
                down = false;
                left = false;
                right = false;
                A = false;
                Dialogue(1);
            }
            if(x > 25 && x < 63 && y < 187 && y > 141 && A)
            {
                up = false;
                down = false;
                left = false;
                right = false;
                A = false;
                Dialogue(2);
            }
            if(x > 175 && x < 211 && y < 163 && y > 115 && A)
            {
                up = false;
                down = false;
                left = false;
                right = false;
                A = false;
                Dialogue(3);
            }
            if(x == 75 && right )
            {
                if(y < 115)
                {
                    x--;
                }
            }
            if(x == 170 && left)
            {
                if(y < 115)
                {
                    x++;
                }
            }
            //mid right fense
            if(y == 227 && up)
            {
                if(x > 69 && x < 179)
                {
                    y++;
                }
            }
            if(y == 180 && down)
            {
                if(x > 69 && x < 179)
                {
                    y--;
                }
            }
            if(x == 181 && left)
            {
                if(y > 177 && y < 227)
                {
                    x++;
                }
            }
            if(x == 69 && right)
            {
                if(y > 177 && y < 227)
                {
                    x--;
                }
            }

            // mid left house
            if(y == 270 && up)
            {
                if(x > 209 && x < 365)
                {
                    y++;
                }
            }
            if(y == 156 && down)
            {
                if(x > 209 && x < 365)
                {
                    y--;
                }
            }
            if(x == 209 && right)
            {
                if(y > 165 && y < 270)
                {
                    x--;
                }
            }
            if(x == 355 && left)
            {
                if(y > 165 && y < 270)
                {
                    x++;
                }
            }
            //top right house
            if(y == 134 && up)
            {
                if(x > 245 && x < 360)
                {
                    y++;
                }
            }

            if(x == 245 && right)
            {
                if(y < 108)
                {
                    x--;
                }
            }
            if(x == 361 && left)
            {
                if(y < 108)
                {
                    x++;
                }
            }
            //water bottom left
            if(x == 180 && left)
            {
                if(y > 289)
                {
                    x++;
                }
            }
            if(y == 289 && down)
            {
                if(x > 65 && x < 180)
                {
                    y--;
                }
            }
            if(x == 65 && right)
            {
                if(y > 289)
                {
                    x--;
                }
            }
            //fence bot right
            if(x == 199 && right)
            {
                if(y > 265 && y < 316)
                {
                    x--;
                }

            }
            if(x == 360 && left)
            {
                if(y > 265 && y < 316)
                {
                    x++;
                }
            }
            if(y == 316 && up)
            {
                if(x > 199 && x < 360)
                {
                    y++;
                }
            }
            if(y == 113 && x > 94 && x < 134)
            {
                roomNum = 7;
            }

            if(y < 0)
            {
                roomNum = 1;
            }
        }
        else if(roomNum == 1)
        {
            if(count < 1)
            {
                y = 615;
                x = 192;
                count++;
            }
            if(x == 30)
            {
                x = 30;
            }
            else if(x == 455)
            {
                x = 455;
            }

            else if(y == 555)
            {
                y = 555;
            }
            else if(y == 25)
            {
                if(!(x <= 232 && x >= 152))
                {
                    y = 25;
                }
            }
            if(y == 433 && up)
            {
                if(x < 191)
                {
                    y++;
                }
            }
            if(x == 191 && left)
            {
                if(y > 362 && y < 433)
                {
                    x++;
                }
            }
            if(y == 362 && down)
            {
                if(x < 191)
                {
                    y--;
                }
            }
            //route 1 grass stuff
            if(y > 560)
            {
                if(x > 189 && x < 206)
                {
                    encounter();
                }
            }
            if(x > 45 && x < 175)
            {
                if(y > 495 && y < 543)
                {
                    encounter();
                }
            }
            if(x > 32 && x < 142)
            {
                if(y > 525)
                {
                    encounter();
                }
            }
            if(x > 220 && x < 320)
            {
                if(y > 525)
                {
                    encounter();
                }

            }
            if(x > 255)
            {
                if(y < 543 && y > 491)
                {
                    encounter();
                }
            }
            if(x > 175 && x < 285)
            {
                if(y < 465 && y > 360)
                {
                    encounter();
                }
            }
            if(x > 165 && x < 287)
            {
                if(y < 462 && y > 361)
                {
                    encounter();
                }
            }
            if(x > 236)
            {
                if(y < 287 && y > 185)
                {
                    encounter();
                }
            }
            if(x > 160)
            {
                if(y > 75 && y < 150)
                {
                    encounter();
                }
            }
            if(x == 325)
            {
                x--;
            }
            if(x == 30)
            {
                x++;
            }
            if(y == 32)
            {
                if((x > 30 && x < 140) || (x > 205 && x < 325))
                {
                    y++;
                }
            }
            if(y == 192 && up)
            {
                if( x < 158)
                {
                    y++;
                }
            }
            if(x == 157 && left)
            {
                if(y  < 192)
                {
                    x++;
                }
            }
            if(y == 270 && up)
            {
                if(x < 254)
                {
                    y++;
                }

            }
            if(y == 200 && down)
            {
                if(x < 254)
                {
                    y--;
                }

            }
            if(x == 255 && left)
            {
                if(y > 200 && y < 270)
                {
                    x++;
                }
            }
            if(y == 555 && down)
            {
                if((x > 30 && x < 165) || (x > 225 && x < 325))
                {
                    y--;
                }
            }
            if(x == 190 && left)
            {
                if(y > 555)
                {
                    x++;
                }
            }
            if(x == 206 && right)
            {
                if(y > 555)
                {
                    x--;
                }
            }
           
            if(y < 0)
            {
                roomNum = 2;
            }
        }
        else if(roomNum == 2)
        {
            if(count < 2)
            {
                x = 384;
                y = 600;
                count++;
            }
            if(x < 100)
            {
                x = 101;
            }
            else if(x > 650)
            {
                x = 649;
            }

            else if(y > 550)
            {
                y = 549;
            }
            else if(y < 25)
            {
                if(!(x <= 404 && x >= 324))
                {
                    y = 25;
                }
            }
            if(y < 0)
            {
                roomNum = 3;
            }

        }
        else if(roomNum == 3)
        {
            if(count < 3)
            {
                x = 127;
                y = 630;
                count++;
            }
            if(x < 20)
            {
                x = 20;
            }
            else if(x > 200)
            {
                x = 199;
            }

            else if(y > 660)
            {
                y = 659;
            }
            else if(y < 190)
            {
                if(!(x <= 108 && x >= 48))
                {
                    y = 191;
                }
            }
            if(x > 84 && x < 195)
            {
                if(y > 261 && y < 341)
                {
                    encounter();
                }
            }
            if(y < 180)
            {
                roomNum = 4;
            }
        }
        else if(roomNum == 4)
        {
            if(count < 4)
            {
                x = 93;
                y = 190;
                count++;
            }
            if(x < 25)
            {
                x = 26;
            }
            else if(x > 170)
            {
                x = 169;
            }

            else if(y > 215)
            {
                y = 214;
            }
            else if(y < 20)
            {
                if(!(x <= 189 && x >= 125))
                {
                    y = 21;
                }
            }
            if(y < 10)
            {
                roomNum = 5;
            }
        }
        else if(roomNum == 5)
        {        
            if(count < 5)
            {
                x = 344;
                y = 530;
                count++;
            }
            if(x < 75)
            {
                x = 76;
            }
            else if(x > 600)
            {
                x = 599;
            }

            else if(y > 560)
            {
                y = 559;
            }
            else if(y < 20)
            {
                y = 21;
            }
        }
        else if(roomNum == 7)
        {
            if(y < 156 && y > 47)
            {
                if(x > 142 && x < 161 && A)
                {
                    up = false;
                    down = false;
                    left = false;
                    right = false;
                    A = false;
                    Dialogue(4);
                }
            }
            if(y > 205)
            {
                roomNum = 0;
                y = 120;
                x = 114;
            }
        }
    }

    public int getRoomNum()
    {
        return roomNum;
    }

    public void draw(Graphics2D g2d)
    {
        g2d.drawImage(getPlayerImage(),x,y,null);
    }

    public Image getPlayerImage()
    {
        ImageIcon i = new ImageIcon(getClass().getResource(playerImage));
        return i.getImage();
    }
}
