import javax.swing.JLabel;
import javax.swing.ImageIcon;
/**
 * description: This is the card class that makes a card and manipulates it
 * 
 * @author Bailey Sachs
 */
public class Card
{

    private int suit;
    private int rank;

    /**
     * Constructor for objects of class Card
     * @param int suit of the card
     * @param int value of the card
     */
    public Card(int s, int r)
    {
        suit = s;
        rank = r;
    }

    /**
     * gets the rank of the card
     * @return String rank of the card
     */
    public String getRank()
    {
        if(rank >= 2 && rank <= 10)
        {
            return "" + rank;
        }
        else if(rank == 1 || rank == 14)
        {
            return "Ace";
        }
        else if(rank == 11)
        {
            return "Jack";
        }
        else if(rank == 12)
        {
            return "Queen";
        }
        else if(rank == 13)
        {
            return "King";
        }
        return "Invalid";
    }

    /**
     * gets the rank of the card for graphics purposes
     * @return String rank of the card
     */
    public String getGraphicsRank()
    {
        if(rank >= 2 && rank <= 10)
        {
            return "" + rank;
        }
        else if(rank == 1 || rank == 14)
        {
            return "A";
        }
        else if(rank == 11)
        {
            return "J";
        }
        else if(rank == 12)
        {
            return "Q";
        }
        else if(rank == 13)
        {
            return "K";
        }
        return "Invalid";
    }

    /**
     * Gets the image of the card and puts it on a jpanel
     * @return JLabel with card on it.
     */
    public JLabel getImage()
    {
        String stuff = "";
        stuff += this.getGraphicsRank();
        stuff+= this.getGraphicsSuit();
        ImageIcon pic = new ImageIcon(stuff + ".png");
        JLabel label = new JLabel("", pic, JLabel.CENTER);
        
        return label;
    }
    
    /**
     * gets the suit of the card for graphics purposes
     * @return String suit of the card
     */
    public String getGraphicsSuit()
    {
        if(suit == 0)
        {
            return "H";
        }
        else if(suit == 1)
        {
            return "D";
        }
        else if(suit == 2)
        {
            return "S";
        }
        else if(suit == 3)
        {
            return "C";
        }
        return "Invalid suit.";
    }

    /**
     * gets the suit of the card
     * @return String suit of the card
     */
    public String getSuit()
    {
        if(suit == 0)
        {
            return "\u2665Hearts\u2665";
        }
        else if(suit == 1)
        {
            return "\u2666Diamonds\u2666";
        }
        else if(suit == 2)
        {
            return "\u2660Spades\u2660";
        }
        else if(suit == 3)
        {
            return "\u2663Clubs\u2663";
        }
        return "Invalid suit.";
    }

    /**
     * gets the value of the card
     * @return int value of the card, returns -1 if the rank is invalid
     */
    public int getValue()
    {
        if(rank >= 2 && rank <= 10)
        {
            return rank;
        }
        else if(rank == 11)
        {
            return 10;
        }
        else if(rank == 12)
        {
            return 10;
        }
        else if(rank == 13)
        {
            return 10;
        }
        else if(rank == 1)
        {
            return 11;
        }
        else if (rank == 14)
        {
            return 1;
        }
        return -1;
    }

    /**
     * sets the suit of the card
     * @param int suit that the card is being changed to
     */
    public void setSuit(int s)
    {
        suit = s;
    }

    /**
     * sets the rank of the card
     * @param rank of the card
     */
    public void setRank(int r)
    {
        rank = r;
    }

    /**
     * sets the value of the ace from the default of 11 to 1
     */
    public void setAceValue()
    {
        rank = 14;
    }

    /**
     * this is the tostring for the card class so when it is printed out it has the right information
     * @return String tostring with information about the card on it.
     */
    public String toString()
    {
        return "The suit is: " + getSuit() + ", the rank is: " + getRank() + ", the value is: " + getValue();
    }
}
