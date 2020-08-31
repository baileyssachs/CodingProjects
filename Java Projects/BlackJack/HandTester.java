
/**
 * Write a description of class HandTester here.
 * This tests the hand class
 * 
 * @author Bailey Sachs 
 */
public class HandTester
{
    public static void main(String [] Args)
    {
        Hand test = new Hand();
        Card a = new Card(1,5);
        Card b = new Card(3,1);
        Card c = new Card(0,1);
        test.addToHand(a);
        test.addToHand(b);
        test.addToHand(c);
        System.out.println(test);  
        Hand busted = new Hand();
        Card d = new Card(2, 10);
        busted.addToHand(d);
        busted.addToHand(d);
        busted.addToHand(a);
        Hand val = new Hand();
        val.addToHand(new Card(0, 1));
        val.addToHand(new Card(1, 1));
        val.addToHand(new Card(1, 2));
        System.out.println("\n" + val);
        System.out.println("The value of the hand is: " + val.getHandValue());

        val.clearHand();
        val.addToHand(new Card(0,1));
        val.addToHand(new Card(1,1));
        val.addToHand(new Card(0,2));
        val.addToHand(new Card(3,8));
        val.addToHand(new Card(3,1));
        System.out.println("\n" + val);
        System.out.println("The value of the hand is: " + val.getHandValue());

        System.out.println("Now testing the bust meathod\n" + busted);
        System.out.println("The player has busted: " + busted.bust());

        Hand blackj = new Hand();
        blackj.addToHand(c);
        blackj.addToHand(d);
        System.out.println(blackj);
        System.out.println("The player has black jack: " + blackj.blackjack());

        Card e = new Card(1,2);
        Hand charlie = new Hand();
        for(int i = 0; i < 5; i++)
        {
            charlie.addToHand(e);
        }
        System.out.println(charlie);
        System.out.println("The player has a 5 card charlie: " + charlie.charlie());

        test.addToHand(b);
        System.out.println(test);
        System.out.println(test.getHandValue());

        test.clearHand();
        System.out.println("Clearing hand, nothing should be below.\n" + test);
    }
}
/*
 * The suit is: ♦Diamonds♦, the rank is: 5, the value is: 5
The suit is: ♣Clubs♣, the rank is: Ace, the value is: 11
The suit is: ♥Hearts♥, the rank is: Ace, the value is: 11

The suit is: ♥Hearts♥, the rank is: Ace, the value is: 11
The suit is: ♦Diamonds♦, the rank is: Ace, the value is: 11
The suit is: ♦Diamonds♦, the rank is: 2, the value is: 2

The value of the hand is: 14

The suit is: ♥Hearts♥, the rank is: Ace, the value is: 11
The suit is: ♦Diamonds♦, the rank is: Ace, the value is: 11
The suit is: ♥Hearts♥, the rank is: 2, the value is: 2
The suit is: ♣Clubs♣, the rank is: 8, the value is: 8
The suit is: ♣Clubs♣, the rank is: Ace, the value is: 11

The value of the hand is: 13
Now testing the bust meathod
The suit is: ♠Spades♠, the rank is: 10, the value is: 10
The suit is: ♠Spades♠, the rank is: 10, the value is: 10
The suit is: ♦Diamonds♦, the rank is: 5, the value is: 5

The player has busted: true
The suit is: ♥Hearts♥, the rank is: Ace, the value is: 11
The suit is: ♠Spades♠, the rank is: 10, the value is: 10

The player has black jack: true
The suit is: ♦Diamonds♦, the rank is: 2, the value is: 2
The suit is: ♦Diamonds♦, the rank is: 2, the value is: 2
The suit is: ♦Diamonds♦, the rank is: 2, the value is: 2
The suit is: ♦Diamonds♦, the rank is: 2, the value is: 2
The suit is: ♦Diamonds♦, the rank is: 2, the value is: 2

The player has a 5 card charlie: true
The suit is: ♦Diamonds♦, the rank is: 5, the value is: 5
The suit is: ♣Clubs♣, the rank is: Ace, the value is: 11
The suit is: ♥Hearts♥, the rank is: Ace, the value is: 11
The suit is: ♣Clubs♣, the rank is: Ace, the value is: 11

18
Clearing hand, nothing should be below.
 */

