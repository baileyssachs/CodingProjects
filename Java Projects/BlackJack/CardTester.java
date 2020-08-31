
/**
 * Description:Tests all of the meathods and constructor in the card class
 * 
 * @author Bailey Sachs
 */
public class CardTester
{
    public static void main (String [] args)
    {
        Card c = new Card(1, 12);//should make a queen of diamonds with a value of 10
        System.out.println("Testing constructor and toString, expected: queen of diamonds with value of 10");
        System.out.println(c);
        System.out.println("Now testing the set meathods, expected: 4 of spades");
        c.setSuit(2);
        c.setRank(4);
        System.out.println(c);
        System.out.println("Now testing the set ace meathod, first line should have a value of 11 and second should have a value of 1");
        c.setRank(1);
        System.out.println(c);
        c.setAceValue();
        System.out.println(c);
        System.out.println("To string for card tests the getValue, getSuit and getRank meathods.");
        System.out.println("Should print jack of clubs with a value of 10");
        c.setSuit(3);
        c.setRank(11);
        System.out.println(c);
    }
}
// Testing constructor and toString, expected: queen of diamonds with value of 10
// The suit is: ♦Diamonds♦, the rank is: Queen, the value is: 10
// Now testing the set meathods, expected: 4 of spades
// The suit is: ♠Spades♠, the rank is: 4, the value is: 4
// Now testing the set ace meathod, first line should have a value of 11 and second should have a value of 1
// The suit is: ♠Spades♠, the rank is: Ace, the value is: 11
// The suit is: ♠Spades♠, the rank is: Ace, the value is: 1
// To string for card tests the getValue, getSuit and getRank meathods.
// Should print jack of clubs with a value of 10
// The suit is: ♣Clubs♣, the rank is: Jack, the value is: 10
