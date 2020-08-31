
/**
 * Write a description of class shoe here.
 * 
 * @author Bailey Sachs
 * @description This class extends the deck class and is the shoe for the dealer to use.
 */
public class shoe extends Deck
{
    /**
     * Constructs a shoe with a specified number of decks
     * 
     * @param int number of decks in the shoe
     */
    public shoe(int n)
    {
        super();
        for(int i = 0; i < n; i++)
        {
            assignValues();
        }
    }
}
