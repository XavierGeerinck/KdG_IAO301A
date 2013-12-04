import be.kdg.blackjack.model.Card;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by xaviergeerinck on 04/12/13.
 *
 * We know that we got cards that we can define with ranks from 1 till 13 (2, 3, ..., 10, jack, queen, king, ace)
 *                                                                        (2, 3, ..., 10,  11 ,  12  ,  13,   1 )
 *
 * An Ace always counts as 11 unless it would jump over 21, then it becomes 1 (So as long as currentValue <= 10)
 *
 * Colors are managed by the value, we got cards 1 - 52, Aces are: 1, 14, 27, 40
 */
public class TestCard {
    @Test
    public void isAceClub1() {
        Card card = new Card(1);
        assertTrue(card.isAce());
        assertEquals(0, card.getColor());
    }

    @Test
    public void isAceHeart14() {
        Card card = new Card(14);
        assertTrue(card.isAce());
        assertEquals(1, card.getColor());
    }

    @Test
    public void isAceDiamond27() {
        Card card = new Card(27);
        assertTrue(card.isAce());
        assertEquals(2, card.getColor());
    }

    @Test
    public void isAceSpade40() {
        Card card = new Card(40);
        assertTrue(card.isAce());
        assertEquals(3, card.getColor());
    }

    // An Ace always counts as 11 unless it would jump over 21, then it becomes 1 (So as long as currentValue <= 10)
    @Test
    public void createAceAs1_WhenCurrentValue14() {
        Card card = new Card(1);
        assertTrue(card.isAce());
        assertEquals(1, card.getPoints(14));
        assertEquals("Ace of Clubs", card.toString());
    }

    @Test
    public void createAceAs1_WhenCurrentValue20() {
        Card card = new Card(14);
        assertTrue(card.isAce());
        assertEquals(1, card.getPoints(20));
        assertEquals("Ace of Hearts", card.toString());
    }

    @Test
    public void createAceAs11_WhenCurrentValue10() {
        Card card = new Card(27);
        assertTrue(card.isAce());
        assertEquals(11, card.getPoints(10));
        assertEquals("Ace of Diamonds", card.toString());
    }

    @Test
    public void createAceAs11_WhenCurrentValue2() {
        Card card = new Card(27);
        assertTrue(card.isAce());
        assertEquals(11, card.getPoints(2));
        assertEquals("Ace of Diamonds", card.toString());
    }

    @Test
    public void createAceAs11_WhenCurrentValue9() {
        Card card = new Card(40);
        assertTrue(card.isAce());
        assertEquals(11, card.getPoints(9));
        assertEquals("Ace of Spades", card.toString());
    }

    @Test
    public void createKingOfHearts() {
        Card card = new Card(26);
        assertEquals(12, card.getValue());
        assertEquals("King of Hearts", card.toString());
    }

    @Test
    public void createQueenOfDiamonds() {
        Card card = new Card(38);
        assertEquals(11, card.getValue());
        assertEquals("Queen of Diamonds", card.toString());
    }

    @Test
    public void createJackOfSpades() {
        Card card = new Card(50);
        assertEquals(10, card.getValue());
        assertEquals("Jack of Spades", card.toString());
    }

    @Test
    public void create10OfClubs() {
        Card card = new Card(10);
        assertEquals(9, card.getValue());
        assertEquals("Ten of Clubs", card.toString());
    }

    @Test
    public void create2OfClubs() {
        Card card = new Card(2);
        assertEquals(1, card.getValue());
        assertEquals("Two of Clubs", card.toString());
    }
}
