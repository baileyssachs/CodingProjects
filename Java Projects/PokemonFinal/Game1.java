import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.net.URL;
import javafx.scene.*;
import javax.sound.sampled.*;
import javafx.stage.Stage;
import java.net.*;
import javafx.application.Application;
/**
 * Game.java  
 *
 */
public class Game1
{
    private JPanel attackPane;
    private GamePanel drawingPanel;
    private JFrame window;
    private JFrame Gwindow;
    private Pokemon player, enemy;
    private boolean playerTurn = true;
    public int Utot, Etot;

    public Game1(Pokemon u,Pokemon e, JFrame g)
    {
        Gwindow = g;
        player = u;
        enemy = e;
        Utot = player.getHealth();
        Etot = enemy.getHealth();
    }

    public void setPokemonEnemy(Pokemon a)
    {
        enemy = a;
    }

    public void healPokemon()
    {
        player.heal();
    }
    
    public void setPokemon(Pokemon u1)
    {
        player = u1;
    }

    public void battle(){
        //Setting up AttackPane
        //Setting up JFrame

        window = new JFrame("Battle");
        window.setSize(800,480);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        //IDK how you want to implement pokemon creation logic, so I used what you had, you could do custom stuff using setPlayerPokemon and setEnemyPokemon

        drawingPanel=new GamePanel(player, enemy);

        //Finalizing Sizing and Content
        window.add(drawingPanel, BorderLayout.NORTH);

        window.setVisible(true);
        drawingPanel.repaint();
        while(player.getHealth() > 0 && enemy.getHealth() > 0)
        {

            hit();

            update();
        }
    }

    public JFrame getFrame()
    {
        return window;
    }

    public void hit()
    {
        if(player.getSpeed() >= enemy.getSpeed())
        {
            Object[] options = player.getMoveSet();
            int red = JOptionPane.showOptionDialog(null, "What attack would you like to choose?", "Attacks", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, null);
            JOptionPane.showMessageDialog(null, "You dealt: " + player.getAttack(red, enemy.getType(), enemy.getDefence(), enemy.getSPDefence()) +" damage.");
            enemy.setHealth(enemy.getHealth() - player.getAttack(red, enemy.getType(), enemy.getDefence(), enemy.getSPDefence()));

            int temp = 0;
            int tempNum = -1;
            for(int i = 0; i < 4; i++)
            {

                if(enemy.getMoveSet()[i].getDamage() > temp)
                {
                    temp = enemy.getMoveSet()[i].getDamage();
                    tempNum = i;
                }

            }
            if(enemy.getHealth() > 0)
            {
                JOptionPane.showMessageDialog(null, "You took: " + enemy.getAttack(tempNum, player.getType(), player.getDefence(), player.getSPDefence()) +" damage.");
                player.setHealth(player.getHealth() - enemy.getAttack(tempNum, player.getType(), player.getDefence(), player.getSPDefence()));
            }

        }
        else if(enemy.getSpeed() > player.getSpeed())
        {
            int temp = 0;
            int tempNum = -1;
            for(int i = 0; i < 4; i++)
            {

                if(enemy.getMoveSet()[i].getDamage() > temp)
                {
                    temp = enemy.getMoveSet()[i].getDamage();
                    tempNum = i;
                }

            }
            player.setHealth(player.getHealth() - enemy.getAttack(tempNum, player.getType(), player.getDefence(), player.getSPDefence()));
            JOptionPane.showMessageDialog(null, "You took: " + enemy.getAttack(tempNum, player.getType(), player.getDefence(), player.getSPDefence()) +" damage.");

            Object[] options = player.getMoveSet();
            int red = JOptionPane.showOptionDialog(null, "What attack would you like to choose?", "Attacks", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, null);
            if(player.getHealth() > 0)
            {
                JOptionPane.showMessageDialog(null, "You dealt: " + player.getAttack(red, enemy.getType(), enemy.getDefence(), enemy.getSPDefence()) +" damage.");
                enemy.setHealth(enemy.getHealth() - player.getAttack(red, enemy.getType(), enemy.getDefence(), enemy.getSPDefence()));

            }

        }
    }

    public void update(){
        //This is where you would add logic for battle, however you want to do it.

        drawingPanel.repaint();
    }

    public class GamePanel extends JPanel{
        //Use BufferedImage instead of ImageIcon
        //They allow you to draw directly to the GamePanel *see paintComponent Method
        //I change the Pokemon getImage() method to return a BufferedImage now
        private BufferedImage background;
        private Pokemon playerPokemon, enemyPokemon;

        public GamePanel(Pokemon u, Pokemon e){
            player = u;
            enemy = e;

            this.setPreferredSize(new Dimension(800,480));
            this.setMinimumSize(new Dimension(800,480));
            this.setMaximumSize(new Dimension(800,480));
            try{
                background=ImageIO.read(getClass().getResourceAsStream("/images/background2.png"));
            }catch(Exception z){
                z.printStackTrace();
            }
        }

        //Modify where things are drawn by changing this method
        public void paintComponent(Graphics g){
            g.drawImage(background, 0, 0, null);
            g.drawImage(player.getImageBack(), 20, 286, null); //150, 250 x y coordinate
            g.drawImage(enemy.getImage(), 500, 102, null);
            g.setColor(Color.BLACK);
            g.drawString(Integer.toString(10),673,311);
            g.drawString(player.getName(), 477, 312);
            g.drawString(Integer.toString(player.getHealth()) + "/" + Integer.toString(Utot), 615, 356);
            g.drawString(enemy.getName(), 200, 102);
            g.drawString(Integer.toString(10), 402, 102);
            g.drawString(Integer.toString(enemy.getHealth()) + "/" + Integer.toString(Etot), 335, 151);
            //             Rectangle rectE = new Rectangle(282, 121, 145 * (enemy.getHealth() / Etot), 8);
            g.setColor(Color.GREEN);
            g.fillRect(275, 121, (int)(145 * ((double)enemy.getHealth() / (double)Etot)), 8);

            g.fillRect(559, 329, (int)(145 * ((double)player.getHealth() / (double)Utot)), 8);
        }
    }
}
