import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.event.KeyListener;
import java.net.URL;
import javafx.scene.*;
import javax.sound.sampled.*;
import javafx.stage.Stage;
import java.net.*;
import javafx.application.Application;
/**
 * Game.java  
 *
 * @author: Bailey and Noah
 * 
 * Brief Program Description:
 * runs the game and calls graphics and sound!
 *
 */
public class Game extends JPanel implements ActionListener
{
    private JFrame frame = new JFrame();
    Timer gameloop;
    Player p;
    private String background1 = "/images/PaletTown.png";
    private String background2 = "/images/Route1.png";
    private String background3 = "/images/Background3.png";
    private String background4 = "/images/route2.png";
    private String background5 = "/images/route22.png";
    private String background6 = "/images/pewter.png";
    private String background7 = "/images/lab.png";
    /**
     * Sets up the game by calling all the other classes and starts the soundtrack
     */
    public Game()
    {

        p = new Player(201,617, frame);

        setFocusable(true);
        gameloop = new Timer(10,this);
        gameloop.start();

        addKeyListener(new KeyInput(p));
        
        try
        {
            AudioInputStream AIS = AudioSystem.getAudioInputStream(this.getClass().getResource("opening.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(AIS);
            clip.start();
        }
        catch(Exception ex)
        {

        }
    }

    /**
     * returns the jframe so we can manipulate it
     * @Returns Jframe
     */
    public JFrame getFrame()
    {
        return frame;
    }

    /**
     * sets the frame size of the jframe
     * @Parameter int x, length of xaxis
     * @Parameter int y, length of yaxis
     */
    public void setFrameSize(int x, int y)
    {
        frame.setSize(x,y);
    }

    /**
     * Paints the picture onto the frame
     * @Parameter Graphics g
     */
    public void paint(Graphics g)
    {
        if(p.getRoomNum() == 0)
        {
            frame.setSize(450,405);
            super.paint(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.drawImage(getBackgroundImage1(), 0,0,this);
            p.draw(g2d);
        }
        else if(p.getRoomNum() == 1)
        {

            frame.setSize(384,640);
            frame.setLocationRelativeTo(null);
            super.paint(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.drawImage(getBackgroundImage2(), 0,0,this);
            p.draw(g2d);

        }
        else if(p.getRoomNum() == 2)
        {
            frame.setSize(768,640);
            frame.setLocationRelativeTo(null);
            super.paint(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.drawImage(getBackgroundImage3(), 0,0,this);
            p.draw(g2d);
        }
        else if(p.getRoomNum() == 3)
        {
            frame.setSize(255,630);
            frame.setLocationRelativeTo(null);
            super.paint(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.drawImage(getBackgroundImage4(), 0,0,this);
            p.draw(g2d);
        }
        else if(p.getRoomNum() == 4)
        {
            frame.setSize(203,343);
            frame.setLocationRelativeTo(null);
            super.paint(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.drawImage(getBackgroundImage5(), 0,0,this);
            p.draw(g2d);
        }
        else if(p.getRoomNum() == 5)
        {
            frame.setSize(768,640);
            frame.setLocationRelativeTo(null);
            super.paint(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.drawImage(getBackgroundImage6(), 0,0,this);
            p.draw(g2d);
        }
        else if(p.getRoomNum() == 7)
        {
            frame.setSize(300,234);
            frame.setLocationRelativeTo(null);
            super.paint(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.drawImage(getBackgroundImage7(), 0,0,this);
            p.draw(g2d);
        }

    }

    /**
     * Gets the image of background1
     * @return Image background image for the frame
     */
    public Image getBackgroundImage1()
    {
        ImageIcon i = new ImageIcon(getClass().getResource(background1));
        return i.getImage();
    }

     /**
     * Gets the image of background2
     * @return Image background image for the frame
     */
    public Image getBackgroundImage2()
    {
        ImageIcon i = new ImageIcon(getClass().getResource(background2));
        return i.getImage();
    }

     /**
     * Gets the image of background3
     * @return Image background image for the frame
     */
    public Image getBackgroundImage3()
    {
        ImageIcon i = new ImageIcon(getClass().getResource(background3));
        return i.getImage();
    }

     /**
     * Gets the image of background4
     * @return Image background image for the frame
     */
    public Image getBackgroundImage4()
    {
        ImageIcon i = new ImageIcon(getClass().getResource(background4));
        return i.getImage();
    }

     /**
     * Gets the image of background5
     * @return Image background image for the frame
     */
    public Image getBackgroundImage5()
    {
        ImageIcon i = new ImageIcon(getClass().getResource(background5));
        return i.getImage();
    }

     /**
     * Gets the image of background6
     * @return Image background image for the frame
     */
    public Image getBackgroundImage6()
    {
        ImageIcon i = new ImageIcon(getClass().getResource(background6));
        return i.getImage();
    }

     /**
     * Gets the image of background7
     * @return Image background image for the frame
     */
    public Image getBackgroundImage7()
    {
        ImageIcon i = new ImageIcon(getClass().getResource(background7));
        return i.getImage();
    }

    /**
     * Returns the player so that it can be manipulatted
     * @return
     */
    public Player getPlayer()
    {
        return p;
    }

    /**
     * updates and repaints the frame as actions happen
     * @param ActionEvent ae, can be any event that triggers the updates.
     */
    public void actionPerformed(ActionEvent ae)
    {
        p.update();
        repaint();
    }
}
