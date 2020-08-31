import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.event.KeyListener;
/**
 * Game.java  
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class Game extends JPanel implements ActionListener
{
    public static final long serialVersionUID = 1L;
    Timer gameloop;
    Player p;
    private String background = "/images/PaletTown.png";
    public Game()
    {

        setFocusable(true);
        gameloop = new Timer(10,this);
        gameloop.start();
        p = new Player(127,163);
        addKeyListener(new KeyInput(p));
    }

    
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(getBackgroundImage(), 0,0,this);
        p.draw(g2d);
        
        
    }
    
    public Image getBackgroundImage()
    {
        ImageIcon i = new ImageIcon(getClass().getResource(background));
        return i.getImage();
    }

  

    public void actionPerformed(ActionEvent ae)
    {
        p.update();
        repaint();

    }
}
