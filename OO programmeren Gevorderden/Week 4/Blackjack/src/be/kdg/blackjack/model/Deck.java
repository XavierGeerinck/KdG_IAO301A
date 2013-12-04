package be.kdg.blackjack.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by xaviergeerinck on 04/12/13.
 */
public class Deck {
    private List<Card> cards;
    private Card card;
    private int currentCard;

    public Deck() {
        currentCard = 0;
        this.cards = new ArrayList<Card>();
        initDeck();
        shuffleCards();
    }

    /*
     * Create 52 cards
     */
    public void initDeck() {
        for (int i = 1; i <= 52; i++) {
            cards.add(new Card(i));
        }
    }

    public void shuffleCards() {
        Collections.shuffle(cards);
    }

    public List<Card> getCards() {
        return cards;
    }

    public Card getCard() {
        Card card = cards.get(currentCard);
        currentCard++;
        return card;
    }
}
