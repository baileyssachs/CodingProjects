
/**
 * Write a description of class Player here.
 * This is the class that holds all of the meathods for the player
 * 
 * @author (your name) Bailey Sachs
 * 
 */
public class Player
{
    private double bankroll;
    private double bet;
    private Hand hand;
    private String name;
    /**
     * constructs a player class with a given bankroll
     * @param double money to start with
     */
    public Player(String s, double money)
    {
        hand = new Hand();
        name = s;
        bankroll = money;
    }

    /**
     * gets the name of the player
     * @return String name of player
     */
    public String getName()
    {
        return name;	
    }

    /**
     * bets a certain ammount of momey
     * @param double ammount of money being bet
     */
    public void bet(double ammount)
    {
        bet = ammount;
        bankroll -= bet;
    }

    /**
     * gets how much the player bet
     * @return double ammount the player bet
     */
    public double getBet()
    {
        return bet;
    }

    /**
     * gets a card from the dealer
     * @param card recieved from the dealer
     */
    public void hit(Card a)
    {
        hand.addToHand(a);
    }

    /**
     * this meathod returns the hand of the player
     * @return hand of the player
     */
    public Hand getHand()
    {
        return hand;
    }

    /**
     * if the player wins the dealer will use this to give them their money back
     */
    public void win()
    {
        int ratio = 2;
        if(hand.blackjack())
        {
            ratio = 3;
        }
        bankroll += bet * ratio;
        bet = 0;
    }

    /**
     * this happens if the player and the dealer draw, it just gives the money back
     */
    public void draw()
    {
        bankroll += bet;
        bet = 0;
    }

    /**
     * this runs if the player lost their hand, resets the bet to 0
     */
    public void lose()
    {
        bet = 0;   
    }

    /**
     * this runs when the player wants to double down, this doubles their bet and only lets them hit once
     */
    public void doubleDown()
    {
        bankroll -= bet;
        bet += bet;
    }

    /**
     * returns the bankroll of the player
     * @return double bankroll of the player
     */
    public double getBankRoll()
    {
        return bankroll;
    }

    /**
     * this is the tostring for the player class
     * @return String tosting for the player class
     */
    public String toString()
    {
        return "Bankroll: " + bankroll + ", the player has bet: " + bet + "\nthe cards in hand are:\n" + hand;
    }
}
