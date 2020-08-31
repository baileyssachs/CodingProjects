import java.util.ArrayList;
/**
 * Write a description of class Hand here.
 * This is the hand class and it holds cards and checks if the player has busted got blackjack or has got a 5 card charlie
 * 
 * @author Bailey Sachs
 */
public class Hand
{
    private ArrayList<Card> hand;

    /**
     * constructor for the hand, initializes the arrayList
     */
    public Hand()
    {
        hand = new ArrayList<Card>();
    }
    
    /**
     * returns the cards in the hand.
     * @return ArrayList<Card> cards in the hand.
     */
    public ArrayList<Card> getCards()
    {
        return hand;
    }

    /**
     * adds a card to the hand
     * @param Card that is going to be added to the hand
     */
    public void addToHand(Card x)
    {
        hand.add(x);
    }

    /**
     * Removes a card from the hand
     * @param Card that is going to be removed from the hand
     */
    public void clearHand()
    {
        int i = hand.size() - 1;
        while(hand.size() > 0) 
        {
            hand.remove(i);
            i--;
        }
    }

    /**
     * Gets the total value of all the cards in the hand
     * @return int value of the hand
     */
    public int getHandValue()
    {
        ArrayList<Card> aces = new ArrayList<Card>();
        int total = 0;
        for(Card x : hand)
        {
            if(x.getValue() == 11)
            {
                aces.add(x);
            }
            total += x.getValue();
        }
        for(Card a : aces)
        {
            if(total > 21)
            {
                a.setAceValue();
                total -= 10; 
            }
        }
        return total;
    }

    /**
     * gets the hand
     * @return ArrayList<Card> of cards with the hand
     */
    public ArrayList<Card> getHand()
    {
        return hand;
    }

    /**
     * checks if the hand has blackjack
     * @return boolean true if there is blackjack and false if there is not.
     */
    public boolean blackjack()
    {
        return hand.size() == 2 && getHandValue() == 21;
    }

    /**
     * checks if the player has busted yet
     * @return boolean true if the hand has over 21
     */
    public boolean bust()
    {
        return getHandValue() > 21;
    }

    /**
     * checks if there is a 5 card charlie
     * @return boolean true if the player has 5 or more cards and hasnt busted yet
     */
    public boolean charlie()
    {
        return getHandValue() <= 21 && hand.size() >= 5;
    }

    /**
     * To string for the hand class so whenever a hand is printed
     * @return String tostring of the hand class
     */
    public String toString()
    {
        String temp = "";
        for(int i = 0; i < hand.size(); i++)
        {
            temp += hand.get(i);
            temp += "\n";
        }
        return temp;
    }
}