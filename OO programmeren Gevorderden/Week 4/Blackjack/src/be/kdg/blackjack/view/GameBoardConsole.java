package be.kdg.blackjack.view;

import be.kdg.blackjack.model.Card;
import be.kdg.blackjack.model.Player;

import java.util.List;

/**
 * Created by xaviergeerinck on 04/12/13.
 */
public class GameBoardConsole {
    public GameBoardConsole() {
    }

    public void printPlayer(Player player) {
        System.out.println("=======================================");
        System.out.printf("Current player: %s\n", player.getName());
        System.out.println("=======================================");
    }

    public void printDrawnCard(Card card) {
        System.out.println("=======================================");
        System.out.printf("Drawn card: %s\n", card.toString());
    }

    public void printAskCard() {
        System.out.printf("Want a card? (1 for yes, 0 for no): ");
    }

    public void printPlayerCards(List<Card> cards, int totalValue) {
        System.out.println("=======================================");
        System.out.println("Cards on board for you:");
        System.out.println("=======================================");

        for (Card card : cards) {
            System.out.println(card);
        }

        System.out.println("- Cards value: " + totalValue);
        System.out.println("=======================================");
    }

    public void printBlackjack(Player player) {
        System.out.println("=======================================");
        System.out.printf("Player: %s has a BLACKJACK!\n", player.getName());
        System.out.println("=======================================");
    }

    public void printPlayerLost(Player player) {
        System.out.println("=======================================");
        System.out.printf("Player %s LOST the game.\n", player.getName());
        System.out.println("=======================================");
    }

    public void printPlayerStopped(Player currentPlayer) {
        System.out.println("=======================================");
        System.out.printf("Player %s stopped asking for cards.\n", currentPlayer.getName());
        System.out.println("=======================================");
    }

    public void printWinner(Player player) {
        System.out.println("=======================================");
        System.out.printf("PLAYER %s WON THE GAME!!!!\n", player.getName());
        System.out.println("=======================================");
    }
}
