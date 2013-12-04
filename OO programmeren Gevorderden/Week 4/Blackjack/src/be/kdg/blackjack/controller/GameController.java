package be.kdg.blackjack.controller;

import be.kdg.blackjack.model.Card;
import be.kdg.blackjack.model.Deck;
import be.kdg.blackjack.model.Player;
import be.kdg.blackjack.view.GameBoardConsole;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xaviergeerinck on 04/12/13.
 */
public class GameController {
    private boolean gameStarted;
    private Deck deck;
    private GameBoardConsole view;
    private List<Player> players;
    private int currentPlayer;

    public GameController() {
        currentPlayer = 0;
        players = new ArrayList<>();
        this.gameStarted = true;
        deck = new Deck();
        view = new GameBoardConsole();
    }

    public boolean isGameStarted() {
        return gameStarted;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public Card askCard() {
        Card card = deck.getCard();
        players.get(currentPlayer).addCard(card);

        return card;
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayer);
    }

    public void endPlayerMove() {
        if (currentPlayer + 1 > players.size() - 1) {
            currentPlayer = 0;
            return;
        }

        currentPlayer++;
    }
}
