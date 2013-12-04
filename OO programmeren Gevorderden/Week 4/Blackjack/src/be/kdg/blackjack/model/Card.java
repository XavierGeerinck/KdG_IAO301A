package be.kdg.blackjack.model;

/**
 * Created by xaviergeerinck on 04/12/13.
 *
 * We know that we got cards that we can define with ranks from 1 till 13 (Ace, 2, 3, ..., 10, jack, queen, king)
 *                                                                        ( 1 , 2, 3, ..., 10,  11 ,  12  ,  13 )
 *
 * An Ace always counts as 11 unless it would jump over 21, then it becomes 1 (So as long as currentValue <= 10)
 * Jack, Queen or King is 10 points
 * 2 .. 10 = their value
 *
 * The ranks are noted the way they are to fit the .jar, used for the GUI
 */

public class Card {
    private int value;
    private int color;
    private static final String RANKS = "A23456789TJQK";
    private static final String[] RANKS_TEXT = { "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
    private static final String SUITS = "CDHS"; // Club, Diamond, Heart, Spade
    private static final String SUITS_TEXT[] = { "Clubs", "Hearts", "Diamonds", "Spades" }; // Club, Diamond, Heart, Spade

    /*
     * We got cards 1 - 52, calculate if it's ace + the suit
     *
     * Ace = if modulo 13 == 1
     * Two = if modulo 13 == 2
     * Queen if modulo 13 == 12
     * King  if modulo 13 = 0!
     * We correct this by doing -1 and giving back 12 when we got card 0
     */
    public Card(int value) {
        this.value = value % 13;
        this.color = (value - 1) / 13; // Calculate it by head, 26 / 13 = 2, we need index 1
    }

    public boolean isAce() {
        return value == 1;
    }

    /*
    * We got cards 1 - 52, calculate if it's ace + the suit
    *
    * Ace = if modulo 13 == 1
    * Two = if modulo 13 == 2
    * Queen if modulo 13 == 12
    * King  if modulo 13 = 0!
    * We correct this by doing -1 and giving back 12 when we got card 0
    */
    public int getValue() {
        if (value == 0) {
            return 12;
        }

        return value - 1;
    }

    /*
     * Club    = 0
     * Heart   = 1
     * Diamond = 2
     * Spade   = 3
     */
    public int getColor() {
        return color;
    }

    /*
     * Ace = 1 or 11, depends on current value
     * Jack, Queen, King = 10 points
     * The rest is their own value
     */
    public int getPoints(int currentValue) {
        // Handle Ace
        if (isAce() && currentValue <= 10) {
            return 11;
        } else if(isAce() && currentValue > 10) {
            return 1;
        // Handle Jack, Queen, King
        } else if(value == 12 || value == 0 || value == 11) {
            return 10;
        // Handle normal cards
        } else {
            return value;
        }
    }

    @Override
    public String toString() {
        return RANKS_TEXT[getValue()] + " of " + SUITS_TEXT[getColor()];
    }
}
