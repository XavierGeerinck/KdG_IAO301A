package be.kdg.blackjack.model;

import be.kdg.blackjack.enums.PlayerResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xaviergeerinck on 04/12/13.
 */
public class Game {
    private boolean gameStarted;
    private Deck deck;
    private List<Player> players;
    private int currentPlayer;

    public Game(ArrayList<Player> players) {
        currentPlayer = 0;
        this.players = players;
        this.gameStarted = true;
        deck = new Deck();
    }

    public boolean isGameStarted() {
        return gameStarted;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public PlayerResult getGameResult() {
        int value = players.get(currentPlayer).getTotalCardValue();

        if (21 == value) {
            getCurrentPlayer().setResult(PlayerResult.BLACKJACK);
        } else if(21 < value) {
            getCurrentPlayer().setResult(PlayerResult.LOST);
        } else {
            getCurrentPlayer().setResult(PlayerResult.STOPPED);
        }

        return getCurrentPlayer().getResult();
    }

    public Card askCard() {
        Card card = deck.getCard();
        players.get(currentPlayer).addCard(card);

        return card;
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayer);
    }

    public Player endPlayerMove() {
        // Check if we are at the last player
        if ((currentPlayer + 1) > (players.size() - 1)) {
            setGameStarted(false);
            return determineWinner();
        }

        currentPlayer++;

        return null;
    }

    private Player determineWinner() {
        Player winner = null;

        for (Player player : players) {
            if (player.getResult() == PlayerResult.LOST) {
                continue;
            }

            if (null == winner) {
                winner = player;
            }

            if (winner.getTotalCardValue() < player.getTotalCardValue()) {
                winner = player;
            }
        }

        return winner;
    }

    public void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
    }

    public boolean getGameStarted() {
        return gameStarted;
    }
}
