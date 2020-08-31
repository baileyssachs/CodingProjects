
/**
 * Write a description of class Dealer here.
 * This is used to run most of the game and to manage all of the other classes
 * 
 * @author (your name) Bailey Sachs
 * 
 */
public class Dealer
{
    private Hand hand;
    private shoe shoe;
    private Player player;
    private double playersBet; 
    
    /**
     * constructs an object of the dealer class
     * @param int number of decks in the shoe
     * @param Player a who will be playing backjack
     */
    public Dealer(int n, Player a)
    {
        hand = new Hand();
        shoe = new shoe(n);
        player = a;
    }
    
    /**
     * gets the shoe of the dealer
     * @return shoe shoe that the dealer has
     */
    public shoe getShoe()
    {
        return shoe;
    }
    
    /**
     * returns the hand of the dealer
     * @return hand the dealer has
     */
    public Hand getHand()
    {
        return hand;
    }
    
    /**
     * returns the player
     * @return Player playing blackjack
     */
    public Player getPlayer()
    {
        return player;
    }

    /**
     * the dealer uses this to let the player bet
     * @Param double n bet the player would like to make
     */
    public void getBet(double n)
    {
        player.bet(n);
    }

    /**
     * This is used to let the player hit
     */
    public void playerHit()
    {
        player.hit(shoe.drawCard());
    }
    
    /**
     * this is used when it is the players turn to determine what they do
     * @param String s players choice of what to do
     */
    public void playersTurn(String s)
    {
        if(s.equals("hit"))
        {
            player.hit(shoe.drawCard());
        }
        else if(s.equals("double down"))
        {
            player.doubleDown();
        }
    }

    /**
     * this is used after the players turn and makes the dealer hit until they have atleast 17
     */
    public void dealersTurn()
    {
        while(hand.getHandValue() <= 16)
        {
            hand.addToHand(shoe.drawCard());   
        }
    }

    /**
     * this starts the game and sets up the hands so they can be player
     */
    public void startGame()
    {
        if(shoe.cardsLeft() <= 20)
        {
            shoe.reShuffle();
        }
        shoe.shuffle();
        player.bet(playersBet);
        player.hit(shoe.drawCard());
        hand.addToHand(shoe.drawCard());
        player.hit(shoe.drawCard());
        hand.addToHand(shoe.drawCard());
        if(player.getHand().blackjack() == true)
        {
            player.win();
        }
    }
}
