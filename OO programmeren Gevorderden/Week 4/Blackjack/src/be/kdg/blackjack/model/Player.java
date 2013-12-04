package be.kdg.blackjack.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xaviergeerinck on 04/12/13.
 */
public class Player {
    private final String name;
    private List<Card> cards;
    private int points;

    public Player(String name) {
        this.cards = new ArrayList<Card>();
        this.name = name;
        this.points = 0;
    }

    public String getName() {
        return name;
    }

    public void askCard() {
    }

    public List<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        cards.add(card);
        points += card.getPoints(points);
    }

    public int getTotalCardValue() {
        return points;
    }
}
