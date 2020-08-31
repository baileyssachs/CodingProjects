
/**
 * Write a description of class deckTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class deckTester
{
    public static void main(String [] args)
    {
        Deck d = new Deck();
        d.assignValues();
        System.out.println(d);
        System.out.println("There are: " + d.cardsLeft() + ", cards left.");
        d.shuffle();
        System.out.println(d);
        Card a = d.drawCard();
        System.out.println(a);
        System.out.println("There are: " + d.cardsLeft() + ", cards left.");
        d.burnCard();
        System.out.println("There are: " + d.cardsLeft() + ", cards left.");
    }
}
// The suit is: ♦Diamonds♦, the rank is: 10, the value is: 10
// The suit is: ♥Hearts♥, the rank is: Ace, the value is: 11
// The suit is: ♣Clubs♣, the rank is: King, the value is: 10
// The suit is: ♠Spades♠, the rank is: King, the value is: 10
// The suit is: ♥Hearts♥, the rank is: 7, the value is: 7
// The suit is: ♦Diamonds♦, the rank is: King, the value is: 10
// The suit is: ♥Hearts♥, the rank is: 9, the value is: 9
// The suit is: ♠Spades♠, the rank is: 7, the value is: 7
// The suit is: ♦Diamonds♦, the rank is: 6, the value is: 6
// The suit is: ♠Spades♠, the rank is: Jack, the value is: 10
// The suit is: ♥Hearts♥, the rank is: 8, the value is: 8
// The suit is: ♦Diamonds♦, the rank is: Queen, the value is: 10
// The suit is: ♠Spades♠, the rank is: 4, the value is: 4
// The suit is: ♣Clubs♣, the rank is: 9, the value is: 9
// The suit is: ♠Spades♠, the rank is: Queen, the value is: 10
// The suit is: ♠Spades♠, the rank is: 8, the value is: 8
// The suit is: ♠Spades♠, the rank is: Ace, the value is: 11
// The suit is: ♣Clubs♣, the rank is: Jack, the value is: 10
// The suit is: ♥Hearts♥, the rank is: 2, the value is: 2
// The suit is: ♠Spades♠, the rank is: 9, the value is: 9
// The suit is: ♦Diamonds♦, the rank is: 2, the value is: 2
// The suit is: ♦Diamonds♦, the rank is: Jack, the value is: 10
// The suit is: ♠Spades♠, the rank is: 5, the value is: 5
// The suit is: ♥Hearts♥, the rank is: 10, the value is: 10
// The suit is: ♦Diamonds♦, the rank is: 7, the value is: 7
// The suit is: ♣Clubs♣, the rank is: 7, the value is: 7
// The suit is: ♣Clubs♣, the rank is: 6, the value is: 6
// The suit is: ♠Spades♠, the rank is: 6, the value is: 6
// The suit is: ♥Hearts♥, the rank is: 5, the value is: 5
// The suit is: ♣Clubs♣, the rank is: 4, the value is: 4
// The suit is: ♣Clubs♣, the rank is: 8, the value is: 8
// The suit is: ♥Hearts♥, the rank is: Queen, the value is: 10
// The suit is: ♣Clubs♣, the rank is: 10, the value is: 10
// The suit is: ♦Diamonds♦, the rank is: 9, the value is: 9
// The suit is: ♠Spades♠, the rank is: 3, the value is: 3
// The suit is: ♦Diamonds♦, the rank is: 5, the value is: 5
// The suit is: ♣Clubs♣, the rank is: 3, the value is: 3
// The suit is: ♥Hearts♥, the rank is: Jack, the value is: 10
// The suit is: ♠Spades♠, the rank is: 2, the value is: 2
// The suit is: ♦Diamonds♦, the rank is: Ace, the value is: 11
// The suit is: ♥Hearts♥, the rank is: 4, the value is: 4
// The suit is: ♣Clubs♣, the rank is: 2, the value is: 2
// The suit is: ♣Clubs♣, the rank is: Queen, the value is: 10
// 
// The suit is: ♦Diamonds♦, the rank is: 4, the value is: 4
// There are: 51, cards left.
// There are: 50, cards left.
