import java.util.Scanner;
/**
 * Write a description of class Game here.
 * This uses all of the classes to make the blackjack game.
 * 
 * @author (your name) Bailey Sachs
 * known bugs: says would u like to play again twice when dealer has blackjack
 */
public class Game
{
    public static void main(String [] main)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("The house rules are:\n You can get a 5 card charlie and if you do you automatically win.\n The house pays out a 2:1 ratio and a 3:1 ratio for BlackJack\n The dealer can not get a 5 card charlie\n The dealer stands on a soft 17.");
        System.out.println("Welcome to the Casino. Please enter your name.");
        String a = sc.nextLine();
        System.out.println("What is your starting bankroll?");
        Double b = sc.nextDouble();
        System.out.println("How many decks do you want to play with?");
        int decks = sc.nextInt();
        Player p = new Player(a, b);
        Dealer d = new Dealer(decks, p);
        String z = "yes";
        while(z.equals("yes"))
        {
            System.out.print("\f");
            d.startGame();
            System.out.println(a + ", what would you like to bet?");
            double g =sc.nextDouble();

            while(g > d.getPlayer().getBankRoll() || g < 0)
            {
                System.out.println("Your bet is to high or below 0, What would you like to bet?");
                g = sc.nextDouble();
            }
            d.getBet(g);
            if(d.getHand().blackjack() == true)
            {
                System.out.println("The dealers hand is: " + d.getHand());
                System.out.println("The dealer has blackjack. You Lose!");
                d.getPlayer().lose();
            }
            if(d.getPlayer().getHand().blackjack() == true)
            {
                System.out.println("\nYour hand is: " + d.getPlayer().getHand());
                System.out.println("You have BlackJack! You win!");
                d.getPlayer().win();
            }
            if(d.getPlayer().getBet() > 0)
            {
                System.out.println("The dealer has: \nBack of card, " + d.getHand().getCards().get(1));

                System.out.println("\nYour hand is: " + d.getPlayer().getHand());
                System.out.println("Your hand value is : " + d.getPlayer().getHand().getHandValue());
                System.out.println("Would you like to hit, stand, or double down?");
                sc.nextLine();
                String c = sc.nextLine();
                while(!c.equals("hit") && !c.equals("stand") && !c.equals("double down"))
                {
                    System.out.println("Invalid input. Please enter hit, stand or double down.");
                    c = sc.nextLine();
                }
                while(c.equals("double down") && g > d.getPlayer().getBankRoll())
                {
                    System.out.println("You dont have enough money. Please chose hit or stand.");
                    c = sc.nextLine();
                }
                while(!c.equals("hit") && !c.equals("stand") && !c.equals("double down"))
                {
                    System.out.println("Invalid input. Please enter hit or stand");
                    c = sc.nextLine();
                }
                d.playersTurn(c);
                if(c.equals("hit") || c.equals("h"))
                {
                    System.out.println("\nYour hand is: " + d.getPlayer().getHand());
                    System.out.println("Your hand value is : " + d.getPlayer().getHand().getHandValue());
                    if(d.getPlayer().getHand().bust() == false)
                    {
                        System.out.println("Would you like to hit again?");
                        String h = sc.nextLine();
                        Boolean f;
                        if(h.equals("yes"))
                        {
                            f = true;
                        }
                        else
                        {
                            f = false;
                        }
                        while(f == true && d.getPlayer().getHand().getHandValue() <= 21)
                        {
                            d.playerHit();
                            System.out.println(d.getPlayer().getHand());
                            System.out.println(d.getPlayer().getHand().getHandValue());
                            if(d.getPlayer().getHand().bust() == false)
                            {
                                if(d.getPlayer().getHand().charlie() == true)
                                {
                                    System.out.println("You have a 5 card charlie! you win!");
                                    d.getPlayer().win();
                                    f = false;
                                }
                                if(d.getPlayer().getBet() > 0)
                                {
                                    System.out.println("Would you like to hit again?");
                                    String temp = sc.nextLine();
                                    if(temp.equals("yes"))
                                    {
                                        f = true;
                                    }
                                    else
                                    {
                                        f = false;
                                    }
                                }
                            }
                            else
                            {
                                System.out.println("\nYour hand is: " + d.getPlayer().getHand());
                                System.out.println("Your hand value is : " + d.getPlayer().getHand().getHandValue());
                                System.out.println("Your busted sorry!");
                                d.getPlayer().lose();
                            }
                        }
                    }
                    else
                    {
                        System.out.println("You busted sorry!");
                        d.getPlayer().lose();
                    }
                }
                else if(c.equals("stand"))
                {
                    if(d.getPlayer().getHand().charlie() == true)
                    {
                        System.out.println("You have a 5 card charlie! you win!");
                        d.getPlayer().win();
                    }
                }
                else if(c.equals("double down"))
                {
                    d.playerHit();
                    System.out.println("\nYour hand is now: " + d.getPlayer().getHand());
                }
                else
                {
                    System.out.println("Invalid input.");
                }
            }
            if(d.getPlayer().getBet() > 0)
            {
                d.dealersTurn();
                System.out.println("\nThe dealer now has: " + d.getHand());
                if(d.getHand().getHandValue() > 21)
                {
                    System.out.println("The dealer busted. You win!");
                    d.getPlayer().win();
                }
                else if(d.getHand().getHandValue() < d.getPlayer().getHand().getHandValue())
                {
                    System.out.println("You Win!");
                    d.getPlayer().win();
                }
                else if(d.getHand().getHandValue() == d.getPlayer().getHand().getHandValue())
                {
                    System.out.println("You both have the same hand value, its a push and you recieve your money back.");
                    d.getPlayer().draw();
                }
                else
                {
                    System.out.println("You lose sorry.");
                    d.getPlayer().lose();
                }
            }

            if(d.getPlayer().getBankRoll() <= 0)
            {
                System.out.println("You ran out of money. Sorry, but you cant keep playing.");
                z = "no";
            }
            else
            {
                System.out.println("You have: " + d.getPlayer().getBankRoll());
                System.out.println("Would you like to play again?");
                Scanner sc2 = new Scanner(System.in);
                z = sc2.nextLine();
                while(!z.equals("yes") && !z.equals("no"))
                {
                    System.out.println("Would you like to play again? Please enter yes or no.");
                    z = sc.nextLine();
                }
            }
            d.getPlayer().getHand().clearHand();
            d.getHand().clearHand();
        }
    }
}
// Run 1:
// The house rules are:
//  You can get a 5 card charlie and if you do you automatically win.
//  The house pays out a 2:1 ratio and a 3:1 ratio for BlackJack
//  The dealer can not get a 5 card charlie
//  The dealer stands on a soft 17.
// Welcome to the Casino. Please enter your name.
// Bailey
// What is your starting bankroll?
// 10000
// How many decks do you want to play with?
// 4
// Bailey, what would you like to bet?
// 5000
// The dealer has: 
// Back of card, The suit is: ♠Spades♠, the rank is: 3, the value is: 3
// 
// Your hand is: The suit is: ♥Hearts♥, the rank is: 9, the value is: 9
// The suit is: ♥Hearts♥, the rank is: 6, the value is: 6
// 
// Your hand value is : 15
// Would you like to hit, stand, or double down?
// hit
// 
// Your hand is: The suit is: ♥Hearts♥, the rank is: 9, the value is: 9
// The suit is: ♥Hearts♥, the rank is: 6, the value is: 6
// The suit is: ♦Diamonds♦, the rank is: 2, the value is: 2
// 
// Your hand value is : 17
// Would you like to hit again?
// no
// 
// The dealer now has: The suit is: ♥Hearts♥, the rank is: 6, the value is: 6
// The suit is: ♠Spades♠, the rank is: 3, the value is: 3
// The suit is: ♥Hearts♥, the rank is: Ace, the value is: 11
// 
// You lose sorry.
// You have: 5000.0
// Would you like to play again?
// yes
// Bailey, what would you like to bet?
// 5000
// The dealer has: 
// Back of card, The suit is: ♠Spades♠, the rank is: 10, the value is: 10
// 
// Your hand is: The suit is: ♦Diamonds♦, the rank is: 9, the value is: 9
// The suit is: ♣Clubs♣, the rank is: 2, the value is: 2
// 
// Your hand value is : 11
// Would you like to hit, stand, or double down?
// hit
// 
// Your hand is: The suit is: ♦Diamonds♦, the rank is: 9, the value is: 9
// The suit is: ♣Clubs♣, the rank is: 2, the value is: 2
// The suit is: ♥Hearts♥, the rank is: Ace, the value is: 11
// 
// Your hand value is : 12
// Would you like to hit again?
// yes
// The suit is: ♦Diamonds♦, the rank is: 9, the value is: 9
// The suit is: ♣Clubs♣, the rank is: 2, the value is: 2
// The suit is: ♥Hearts♥, the rank is: Ace, the value is: 1
// The suit is: ♣Clubs♣, the rank is: Queen, the value is: 10
// 
// 22
// 
// Your hand is: The suit is: ♦Diamonds♦, the rank is: 9, the value is: 9
// The suit is: ♣Clubs♣, the rank is: 2, the value is: 2
// The suit is: ♥Hearts♥, the rank is: Ace, the value is: 1
// The suit is: ♣Clubs♣, the rank is: Queen, the value is: 10
// 
// Your hand value is : 22
// Your busted sorry!
// You ran out of money. Sorry, but you cant keep playing.
// Run 2:
// The house rules are:
//  You can get a 5 card charlie and if you do you automatically win.
//  The house pays out a 2:1 ratio and a 3:1 ratio for BlackJack
//  The dealer can not get a 5 card charlie
//  The dealer stands on a soft 17.
// Welcome to the Casino. Please enter your name.
// Bob
// What is your starting bankroll?
// 1000000
// How many decks do you want to play with?
// 7
// Bob, what would you like to bet?
// 500000
// The dealer has: 
// Back of card, The suit is: ♥Hearts♥, the rank is: 10, the value is: 10
// 
// Your hand is: The suit is: ♦Diamonds♦, the rank is: Jack, the value is: 10
// The suit is: ♦Diamonds♦, the rank is: Jack, the value is: 10
// 
// Your hand value is : 20
// Would you like to hit, stand, or double down?
// stand
// 
// The dealer now has: The suit is: ♥Hearts♥, the rank is: 10, the value is: 10
// The suit is: ♥Hearts♥, the rank is: 10, the value is: 10
// 
// You both have the same hand value, its a push and you recieve your money back.
// You have: 1000000.0
// Would you like to play again?
// yes
// Bob, what would you like to bet?
// 500000
// The dealer has: 
// Back of card, The suit is: ♣Clubs♣, the rank is: 7, the value is: 7
// 
// Your hand is: The suit is: ♥Hearts♥, the rank is: 5, the value is: 5
// The suit is: ♦Diamonds♦, the rank is: 7, the value is: 7
// 
// Your hand value is : 12
// Would you like to hit, stand, or double down?
// double down
// 
// Your hand is now: The suit is: ♥Hearts♥, the rank is: 5, the value is: 5
// The suit is: ♦Diamonds♦, the rank is: 7, the value is: 7
// The suit is: ♣Clubs♣, the rank is: 3, the value is: 3
// 
// 
// The dealer now has: The suit is: ♥Hearts♥, the rank is: King, the value is: 10
// The suit is: ♣Clubs♣, the rank is: 7, the value is: 7
// 
// You lose sorry.
// You ran out of money. Sorry, but you cant keep playing.
