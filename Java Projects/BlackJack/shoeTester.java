
/**
 * Write a description of class shoeTester here.
 * This tests the shoe class and its meathods.
 * 
 * 
 * @author Bailey Sachs
 */
public class shoeTester
{
    public static void main(String [] Args)
    {
        shoe test = new shoe(3);
        System.out.println(test);
        System.out.println("Now shuffling.\n");
        test.shuffle();
        System.out.println(test);
        System.out.println("Now testing get card\n");
        Card a = test.drawCard();
        System.out.println(a);
        System.out.println(test.cardsLeft());
        System.out.println("Now Burning a card.");
        test.burnCard();
        System.out.println(test.cardsLeft());

    }
}
/*
 * The cards in the deck are: The suit is: ♥Hearts♥, the rank is: Ace, the value is: 11
The suit is: ♥Hearts♥, the rank is: 2, the value is: 2
The suit is: ♥Hearts♥, the rank is: 3, the value is: 3
The suit is: ♥Hearts♥, the rank is: 4, the value is: 4
The suit is: ♥Hearts♥, the rank is: 5, the value is: 5
The suit is: ♥Hearts♥, the rank is: 6, the value is: 6
The suit is: ♥Hearts♥, the rank is: 7, the value is: 7
The suit is: ♥Hearts♥, the rank is: 8, the value is: 8
The suit is: ♥Hearts♥, the rank is: 9, the value is: 9
The suit is: ♥Hearts♥, the rank is: 10, the value is: 10
The suit is: ♥Hearts♥, the rank is: Jack, the value is: 10
The suit is: ♥Hearts♥, the rank is: Queen, the value is: 10
The suit is: ♥Hearts♥, the rank is: King, the value is: 10
The suit is: ♦Diamonds♦, the rank is: Ace, the value is: 11
The suit is: ♦Diamonds♦, the rank is: 2, the value is: 2
The suit is: ♦Diamonds♦, the rank is: 3, the value is: 3
The suit is: ♦Diamonds♦, the rank is: 4, the value is: 4
The suit is: ♦Diamonds♦, the rank is: 5, the value is: 5
The suit is: ♦Diamonds♦, the rank is: 6, the value is: 6
The suit is: ♦Diamonds♦, the rank is: 7, the value is: 7
The suit is: ♦Diamonds♦, the rank is: 8, the value is: 8
The suit is: ♦Diamonds♦, the rank is: 9, the value is: 9
The suit is: ♦Diamonds♦, the rank is: 10, the value is: 10
The suit is: ♦Diamonds♦, the rank is: Jack, the value is: 10
The suit is: ♦Diamonds♦, the rank is: Queen, the value is: 10
The suit is: ♦Diamonds♦, the rank is: King, the value is: 10
The suit is: ♠Spades♠, the rank is: King, the value is: 10
The suit is: ♠Spades♠, the rank is: Queen, the value is: 10
The suit is: ♠Spades♠, the rank is: Jack, the value is: 10
The suit is: ♠Spades♠, the rank is: 10, the value is: 10
The suit is: ♠Spades♠, the rank is: 9, the value is: 9
The suit is: ♠Spades♠, the rank is: 8, the value is: 8
The suit is: ♠Spades♠, the rank is: 7, the value is: 7
The suit is: ♠Spades♠, the rank is: 6, the value is: 6
The suit is: ♠Spades♠, the rank is: 5, the value is: 5
The suit is: ♠Spades♠, the rank is: 4, the value is: 4
The suit is: ♠Spades♠, the rank is: 3, the value is: 3
The suit is: ♠Spades♠, the rank is: 2, the value is: 2
The suit is: ♠Spades♠, the rank is: Ace, the value is: 11
The suit is: ♣Clubs♣, the rank is: King, the value is: 10
The suit is: ♣Clubs♣, the rank is: Queen, the value is: 10
The suit is: ♣Clubs♣, the rank is: Jack, the value is: 10
The suit is: ♣Clubs♣, the rank is: 10, the value is: 10
The suit is: ♣Clubs♣, the rank is: 9, the value is: 9
The suit is: ♣Clubs♣, the rank is: 8, the value is: 8
The suit is: ♣Clubs♣, the rank is: 7, the value is: 7
The suit is: ♣Clubs♣, the rank is: 6, the value is: 6
The suit is: ♣Clubs♣, the rank is: 5, the value is: 5
The suit is: ♣Clubs♣, the rank is: 4, the value is: 4
The suit is: ♣Clubs♣, the rank is: 3, the value is: 3
The suit is: ♣Clubs♣, the rank is: 2, the value is: 2
The suit is: ♣Clubs♣, the rank is: Ace, the value is: 11
The suit is: ♥Hearts♥, the rank is: Ace, the value is: 11
The suit is: ♥Hearts♥, the rank is: 2, the value is: 2
The suit is: ♥Hearts♥, the rank is: 3, the value is: 3
The suit is: ♥Hearts♥, the rank is: 4, the value is: 4
The suit is: ♥Hearts♥, the rank is: 5, the value is: 5
The suit is: ♥Hearts♥, the rank is: 6, the value is: 6
The suit is: ♥Hearts♥, the rank is: 7, the value is: 7
The suit is: ♥Hearts♥, the rank is: 8, the value is: 8
The suit is: ♥Hearts♥, the rank is: 9, the value is: 9
The suit is: ♥Hearts♥, the rank is: 10, the value is: 10
The suit is: ♥Hearts♥, the rank is: Jack, the value is: 10
The suit is: ♥Hearts♥, the rank is: Queen, the value is: 10
The suit is: ♥Hearts♥, the rank is: King, the value is: 10
The suit is: ♦Diamonds♦, the rank is: Ace, the value is: 11
The suit is: ♦Diamonds♦, the rank is: 2, the value is: 2
The suit is: ♦Diamonds♦, the rank is: 3, the value is: 3
The suit is: ♦Diamonds♦, the rank is: 4, the value is: 4
The suit is: ♦Diamonds♦, the rank is: 5, the value is: 5
The suit is: ♦Diamonds♦, the rank is: 6, the value is: 6
The suit is: ♦Diamonds♦, the rank is: 7, the value is: 7
The suit is: ♦Diamonds♦, the rank is: 8, the value is: 8
The suit is: ♦Diamonds♦, the rank is: 9, the value is: 9
The suit is: ♦Diamonds♦, the rank is: 10, the value is: 10
The suit is: ♦Diamonds♦, the rank is: Jack, the value is: 10
The suit is: ♦Diamonds♦, the rank is: Queen, the value is: 10
The suit is: ♦Diamonds♦, the rank is: King, the value is: 10
The suit is: ♠Spades♠, the rank is: King, the value is: 10
The suit is: ♠Spades♠, the rank is: Queen, the value is: 10
The suit is: ♠Spades♠, the rank is: Jack, the value is: 10
The suit is: ♠Spades♠, the rank is: 10, the value is: 10
The suit is: ♠Spades♠, the rank is: 9, the value is: 9
The suit is: ♠Spades♠, the rank is: 8, the value is: 8
The suit is: ♠Spades♠, the rank is: 7, the value is: 7
The suit is: ♠Spades♠, the rank is: 6, the value is: 6
The suit is: ♠Spades♠, the rank is: 5, the value is: 5
The suit is: ♠Spades♠, the rank is: 4, the value is: 4
The suit is: ♠Spades♠, the rank is: 3, the value is: 3
The suit is: ♠Spades♠, the rank is: 2, the value is: 2
The suit is: ♠Spades♠, the rank is: Ace, the value is: 11
The suit is: ♣Clubs♣, the rank is: King, the value is: 10
The suit is: ♣Clubs♣, the rank is: Queen, the value is: 10
The suit is: ♣Clubs♣, the rank is: Jack, the value is: 10
The suit is: ♣Clubs♣, the rank is: 10, the value is: 10
The suit is: ♣Clubs♣, the rank is: 9, the value is: 9
The suit is: ♣Clubs♣, the rank is: 8, the value is: 8
The suit is: ♣Clubs♣, the rank is: 7, the value is: 7
The suit is: ♣Clubs♣, the rank is: 6, the value is: 6
The suit is: ♣Clubs♣, the rank is: 5, the value is: 5
The suit is: ♣Clubs♣, the rank is: 4, the value is: 4
The suit is: ♣Clubs♣, the rank is: 3, the value is: 3
The suit is: ♣Clubs♣, the rank is: 2, the value is: 2
The suit is: ♣Clubs♣, the rank is: Ace, the value is: 11
The suit is: ♥Hearts♥, the rank is: Ace, the value is: 11
The suit is: ♥Hearts♥, the rank is: 2, the value is: 2
The suit is: ♥Hearts♥, the rank is: 3, the value is: 3
The suit is: ♥Hearts♥, the rank is: 4, the value is: 4
The suit is: ♥Hearts♥, the rank is: 5, the value is: 5
The suit is: ♥Hearts♥, the rank is: 6, the value is: 6
The suit is: ♥Hearts♥, the rank is: 7, the value is: 7
The suit is: ♥Hearts♥, the rank is: 8, the value is: 8
The suit is: ♥Hearts♥, the rank is: 9, the value is: 9
The suit is: ♥Hearts♥, the rank is: 10, the value is: 10
The suit is: ♥Hearts♥, the rank is: Jack, the value is: 10
The suit is: ♥Hearts♥, the rank is: Queen, the value is: 10
The suit is: ♥Hearts♥, the rank is: King, the value is: 10
The suit is: ♦Diamonds♦, the rank is: Ace, the value is: 11
The suit is: ♦Diamonds♦, the rank is: 2, the value is: 2
The suit is: ♦Diamonds♦, the rank is: 3, the value is: 3
The suit is: ♦Diamonds♦, the rank is: 4, the value is: 4
The suit is: ♦Diamonds♦, the rank is: 5, the value is: 5
The suit is: ♦Diamonds♦, the rank is: 6, the value is: 6
The suit is: ♦Diamonds♦, the rank is: 7, the value is: 7
The suit is: ♦Diamonds♦, the rank is: 8, the value is: 8
The suit is: ♦Diamonds♦, the rank is: 9, the value is: 9
The suit is: ♦Diamonds♦, the rank is: 10, the value is: 10
The suit is: ♦Diamonds♦, the rank is: Jack, the value is: 10
The suit is: ♦Diamonds♦, the rank is: Queen, the value is: 10
The suit is: ♦Diamonds♦, the rank is: King, the value is: 10
The suit is: ♠Spades♠, the rank is: King, the value is: 10
The suit is: ♠Spades♠, the rank is: Queen, the value is: 10
The suit is: ♠Spades♠, the rank is: Jack, the value is: 10
The suit is: ♠Spades♠, the rank is: 10, the value is: 10
The suit is: ♠Spades♠, the rank is: 9, the value is: 9
The suit is: ♠Spades♠, the rank is: 8, the value is: 8
The suit is: ♠Spades♠, the rank is: 7, the value is: 7
The suit is: ♠Spades♠, the rank is: 6, the value is: 6
The suit is: ♠Spades♠, the rank is: 5, the value is: 5
The suit is: ♠Spades♠, the rank is: 4, the value is: 4
The suit is: ♠Spades♠, the rank is: 3, the value is: 3
The suit is: ♠Spades♠, the rank is: 2, the value is: 2
The suit is: ♠Spades♠, the rank is: Ace, the value is: 11
The suit is: ♣Clubs♣, the rank is: King, the value is: 10
The suit is: ♣Clubs♣, the rank is: Queen, the value is: 10
The suit is: ♣Clubs♣, the rank is: Jack, the value is: 10
The suit is: ♣Clubs♣, the rank is: 10, the value is: 10
The suit is: ♣Clubs♣, the rank is: 9, the value is: 9
The suit is: ♣Clubs♣, the rank is: 8, the value is: 8
The suit is: ♣Clubs♣, the rank is: 7, the value is: 7
The suit is: ♣Clubs♣, the rank is: 6, the value is: 6
The suit is: ♣Clubs♣, the rank is: 5, the value is: 5
The suit is: ♣Clubs♣, the rank is: 4, the value is: 4
The suit is: ♣Clubs♣, the rank is: 3, the value is: 3
The suit is: ♣Clubs♣, the rank is: 2, the value is: 2
The suit is: ♣Clubs♣, the rank is: Ace, the value is: 11

Now shuffling.

The cards in the deck are: The suit is: ♥Hearts♥, the rank is: King, the value is: 10
The suit is: ♠Spades♠, the rank is: 3, the value is: 3
The suit is: ♣Clubs♣, the rank is: 9, the value is: 9
The suit is: ♠Spades♠, the rank is: Jack, the value is: 10
The suit is: ♣Clubs♣, the rank is: 10, the value is: 10
The suit is: ♥Hearts♥, the rank is: Ace, the value is: 11
The suit is: ♦Diamonds♦, the rank is: 4, the value is: 4
The suit is: ♦Diamonds♦, the rank is: 10, the value is: 10
The suit is: ♦Diamonds♦, the rank is: 10, the value is: 10
The suit is: ♦Diamonds♦, the rank is: 9, the value is: 9
The suit is: ♥Hearts♥, the rank is: 5, the value is: 5
The suit is: ♥Hearts♥, the rank is: 5, the value is: 5
The suit is: ♦Diamonds♦, the rank is: 3, the value is: 3
The suit is: ♥Hearts♥, the rank is: Queen, the value is: 10
The suit is: ♣Clubs♣, the rank is: 2, the value is: 2
The suit is: ♠Spades♠, the rank is: 4, the value is: 4
The suit is: ♥Hearts♥, the rank is: 3, the value is: 3
The suit is: ♦Diamonds♦, the rank is: 5, the value is: 5
The suit is: ♣Clubs♣, the rank is: 7, the value is: 7
The suit is: ♠Spades♠, the rank is: 2, the value is: 2
The suit is: ♣Clubs♣, the rank is: 6, the value is: 6
The suit is: ♠Spades♠, the rank is: Ace, the value is: 11
The suit is: ♥Hearts♥, the rank is: 9, the value is: 9
The suit is: ♥Hearts♥, the rank is: 7, the value is: 7
The suit is: ♥Hearts♥, the rank is: 8, the value is: 8
The suit is: ♣Clubs♣, the rank is: 10, the value is: 10
The suit is: ♣Clubs♣, the rank is: 10, the value is: 10
The suit is: ♣Clubs♣, the rank is: Jack, the value is: 10
The suit is: ♣Clubs♣, the rank is: Ace, the value is: 11
The suit is: ♥Hearts♥, the rank is: 8, the value is: 8
The suit is: ♦Diamonds♦, the rank is: King, the value is: 10
The suit is: ♣Clubs♣, the rank is: 6, the value is: 6
The suit is: ♦Diamonds♦, the rank is: 3, the value is: 3
The suit is: ♣Clubs♣, the rank is: Jack, the value is: 10
The suit is: ♣Clubs♣, the rank is: 8, the value is: 8
The suit is: ♦Diamonds♦, the rank is: 3, the value is: 3
The suit is: ♣Clubs♣, the rank is: 7, the value is: 7
The suit is: ♠Spades♠, the rank is: 6, the value is: 6
The suit is: ♦Diamonds♦, the rank is: Queen, the value is: 10
The suit is: ♠Spades♠, the rank is: Queen, the value is: 10
The suit is: ♥Hearts♥, the rank is: 2, the value is: 2
The suit is: ♦Diamonds♦, the rank is: Jack, the value is: 10
The suit is: ♦Diamonds♦, the rank is: 2, the value is: 2
The suit is: ♣Clubs♣, the rank is: Queen, the value is: 10
The suit is: ♥Hearts♥, the rank is: 6, the value is: 6
The suit is: ♣Clubs♣, the rank is: 6, the value is: 6
The suit is: ♠Spades♠, the rank is: 8, the value is: 8
The suit is: ♥Hearts♥, the rank is: 2, the value is: 2
The suit is: ♠Spades♠, the rank is: 4, the value is: 4
The suit is: ♠Spades♠, the rank is: 4, the value is: 4
The suit is: ♥Hearts♥, the rank is: Queen, the value is: 10
The suit is: ♦Diamonds♦, the rank is: Ace, the value is: 11
The suit is: ♣Clubs♣, the rank is: Queen, the value is: 10
The suit is: ♠Spades♠, the rank is: King, the value is: 10
The suit is: ♥Hearts♥, the rank is: 10, the value is: 10
The suit is: ♣Clubs♣, the rank is: King, the value is: 10
The suit is: ♥Hearts♥, the rank is: Ace, the value is: 11
The suit is: ♣Clubs♣, the rank is: 3, the value is: 3
The suit is: ♠Spades♠, the rank is: Ace, the value is: 11
The suit is: ♣Clubs♣, the rank is: King, the value is: 10
The suit is: ♦Diamonds♦, the rank is: 10, the value is: 10
The suit is: ♠Spades♠, the rank is: King, the value is: 10
The suit is: ♦Diamonds♦, the rank is: Jack, the value is: 10
The suit is: ♦Diamonds♦, the rank is: 5, the value is: 5
The suit is: ♠Spades♠, the rank is: 5, the value is: 5
The suit is: ♣Clubs♣, the rank is: 4, the value is: 4
The suit is: ♣Clubs♣, the rank is: 8, the value is: 8
The suit is: ♠Spades♠, the rank is: Jack, the value is: 10
The suit is: ♣Clubs♣, the rank is: 3, the value is: 3
The suit is: ♠Spades♠, the rank is: Jack, the value is: 10
The suit is: ♠Spades♠, the rank is: Ace, the value is: 11
The suit is: ♥Hearts♥, the rank is: 10, the value is: 10
The suit is: ♥Hearts♥, the rank is: King, the value is: 10
The suit is: ♠Spades♠, the rank is: Queen, the value is: 10
The suit is: ♦Diamonds♦, the rank is: 7, the value is: 7
The suit is: ♣Clubs♣, the rank is: 8, the value is: 8
The suit is: ♠Spades♠, the rank is: 2, the value is: 2
The suit is: ♠Spades♠, the rank is: 5, the value is: 5
The suit is: ♦Diamonds♦, the rank is: 6, the value is: 6
The suit is: ♦Diamonds♦, the rank is: Queen, the value is: 10
The suit is: ♣Clubs♣, the rank is: Ace, the value is: 11
The suit is: ♠Spades♠, the rank is: 7, the value is: 7
The suit is: ♥Hearts♥, the rank is: King, the value is: 10
The suit is: ♠Spades♠, the rank is: King, the value is: 10
The suit is: ♠Spades♠, the rank is: 6, the value is: 6
The suit is: ♦Diamonds♦, the rank is: 5, the value is: 5
The suit is: ♦Diamonds♦, the rank is: 4, the value is: 4
The suit is: ♥Hearts♥, the rank is: Jack, the value is: 10
The suit is: ♠Spades♠, the rank is: 10, the value is: 10
The suit is: ♠Spades♠, the rank is: 8, the value is: 8
The suit is: ♥Hearts♥, the rank is: 4, the value is: 4
The suit is: ♦Diamonds♦, the rank is: 2, the value is: 2
The suit is: ♣Clubs♣, the rank is: Queen, the value is: 10
The suit is: ♦Diamonds♦, the rank is: 8, the value is: 8
The suit is: ♦Diamonds♦, the rank is: 9, the value is: 9
The suit is: ♦Diamonds♦, the rank is: 4, the value is: 4
The suit is: ♠Spades♠, the rank is: 3, the value is: 3
The suit is: ♦Diamonds♦, the rank is: 7, the value is: 7
The suit is: ♦Diamonds♦, the rank is: King, the value is: 10
The suit is: ♦Diamonds♦, the rank is: 6, the value is: 6
The suit is: ♥Hearts♥, the rank is: 4, the value is: 4
The suit is: ♥Hearts♥, the rank is: Jack, the value is: 10
The suit is: ♠Spades♠, the rank is: 6, the value is: 6
The suit is: ♠Spades♠, the rank is: 5, the value is: 5
The suit is: ♥Hearts♥, the rank is: 5, the value is: 5
The suit is: ♦Diamonds♦, the rank is: 8, the value is: 8
The suit is: ♦Diamonds♦, the rank is: 7, the value is: 7
The suit is: ♥Hearts♥, the rank is: 8, the value is: 8
The suit is: ♦Diamonds♦, the rank is: Ace, the value is: 11
The suit is: ♥Hearts♥, the rank is: Jack, the value is: 10
The suit is: ♣Clubs♣, the rank is: 9, the value is: 9
The suit is: ♦Diamonds♦, the rank is: Jack, the value is: 10
The suit is: ♠Spades♠, the rank is: 7, the value is: 7
The suit is: ♥Hearts♥, the rank is: 7, the value is: 7
The suit is: ♣Clubs♣, the rank is: Jack, the value is: 10
The suit is: ♣Clubs♣, the rank is: 4, the value is: 4
The suit is: ♣Clubs♣, the rank is: 5, the value is: 5
The suit is: ♦Diamonds♦, the rank is: 8, the value is: 8
The suit is: ♣Clubs♣, the rank is: 4, the value is: 4
The suit is: ♠Spades♠, the rank is: 7, the value is: 7
The suit is: ♣Clubs♣, the rank is: 5, the value is: 5
The suit is: ♥Hearts♥, the rank is: 7, the value is: 7
The suit is: ♥Hearts♥, the rank is: 9, the value is: 9
The suit is: ♦Diamonds♦, the rank is: 9, the value is: 9
The suit is: ♣Clubs♣, the rank is: 3, the value is: 3
The suit is: ♣Clubs♣, the rank is: 2, the value is: 2
The suit is: ♥Hearts♥, the rank is: 6, the value is: 6
The suit is: ♥Hearts♥, the rank is: Ace, the value is: 11
The suit is: ♠Spades♠, the rank is: Queen, the value is: 10
The suit is: ♣Clubs♣, the rank is: Ace, the value is: 11
The suit is: ♣Clubs♣, the rank is: 2, the value is: 2
The suit is: ♣Clubs♣, the rank is: King, the value is: 10
The suit is: ♠Spades♠, the rank is: 9, the value is: 9
The suit is: ♠Spades♠, the rank is: 2, the value is: 2
The suit is: ♥Hearts♥, the rank is: 3, the value is: 3
The suit is: ♥Hearts♥, the rank is: Queen, the value is: 10
The suit is: ♠Spades♠, the rank is: 3, the value is: 3
The suit is: ♣Clubs♣, the rank is: 9, the value is: 9
The suit is: ♠Spades♠, the rank is: 10, the value is: 10
The suit is: ♦Diamonds♦, the rank is: 2, the value is: 2
The suit is: ♠Spades♠, the rank is: 8, the value is: 8
The suit is: ♥Hearts♥, the rank is: 3, the value is: 3
The suit is: ♦Diamonds♦, the rank is: Ace, the value is: 11
The suit is: ♥Hearts♥, the rank is: 6, the value is: 6
The suit is: ♦Diamonds♦, the rank is: King, the value is: 10
The suit is: ♠Spades♠, the rank is: 9, the value is: 9
The suit is: ♥Hearts♥, the rank is: 10, the value is: 10
The suit is: ♠Spades♠, the rank is: 10, the value is: 10
The suit is: ♣Clubs♣, the rank is: 5, the value is: 5
The suit is: ♥Hearts♥, the rank is: 9, the value is: 9
The suit is: ♦Diamonds♦, the rank is: 6, the value is: 6
The suit is: ♥Hearts♥, the rank is: 2, the value is: 2
The suit is: ♠Spades♠, the rank is: 9, the value is: 9
The suit is: ♦Diamonds♦, the rank is: Queen, the value is: 10
The suit is: ♣Clubs♣, the rank is: 7, the value is: 7
The suit is: ♥Hearts♥, the rank is: 4, the value is: 4

Now testing get card

The suit is: ♥Hearts♥, the rank is: King, the value is: 10
155
Now Burning a card.
154

 */