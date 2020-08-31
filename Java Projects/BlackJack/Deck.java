import java.util.ArrayList;
/**
 * Write a description of class Deck here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Deck
{
    private ArrayList<Card> deck;
    private ArrayList<Card> discard;
    /**
     * Constructor for objects of class Deck
     */
    public Deck()
    {
        deck = new ArrayList<Card>();
        discard = new ArrayList<Card>();
    }

    /**
     * This puts all 52 cards into the deck
     */
    public void assignValues()
    {
        for(int s = 0; s < 2; s++)
        {
            for(int v = 1; v <= 13; v++)
            {
                deck.add(new Card(s, v));
            }
        }
        for(int s = 2; s < 4; s++)
        {
            for(int v = 13; v >= 1; v--)
            {
                deck.add(new Card(s, v));
            }
        }
    }

    /**
     * This shuffles the deck
     */
    public void shuffle()
    {
        Card[] tdeck = new Card[deck.size()];
        deck.toArray(tdeck);
        for(int i = 0; i < tdeck.length; i++)
        {
            int random =(int)(Math.random() * deck.size());    
            Card temp = tdeck[random];
            tdeck[random] = tdeck[i];
            tdeck[i] = temp;
        }
        ArrayList<Card> re = new ArrayList<Card>();
        for(int i = 0; i < tdeck.length; i++)
        {
            re.add(tdeck[i]);
        }
        deck = re;
    }
    
    /**
     * This puts all the discarded cards back into the deck and shuffles it
     */
    public void reShuffle()
    {
        for(Card x: discard)
        {
            deck.add(x);
        }
        shuffle();
    }

    /**
     * This draws a card from the deck
     * 
     * @return Card drawn from the deck
     */
    public Card drawCard()
    {
        Card temp = deck.get(0);
        deck.remove(0);
        discard.add(temp);
        return temp;
    }

    /**
     * gets the deck
     * @return ArrayList<card> deck
     */
    public ArrayList<Card> getDeck()
    {
        return deck;
    }
    
    /**
     * gets the number of cards left in the deck
     * @return int cards left in the deck
     */
    public int cardsLeft()
    {
        return deck.size();
    }

    /**
     * burns a card from the deck
     */
    public void burnCard()
    {
        Card temp = deck.get(0);
        deck.remove(0);
        discard.add(temp);
    }
    
    /**
     * This is the tostring for the deck
     * @return String tostring of the deck
     */
    public String toString()
    {
        String temp = "The cards in the deck are: ";
        for(int i = 0; i < deck.size(); i++)
        {
            temp += deck.get(i) + "\n";
        }
        return temp;
    }

}