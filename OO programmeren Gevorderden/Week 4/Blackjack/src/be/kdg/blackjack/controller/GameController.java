package be.kdg.blackjack.controller;

import be.kdg.blackjack.model.Card;
import be.kdg.blackjack.model.Deck;
import be.kdg.blackjack.model.Game;
import be.kdg.blackjack.model.Player;
import be.kdg.blackjack.view.GameBoardConsole;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by xaviergeerinck on 04/12/13.
 */
public class GameController {
    private GameBoardConsole view;
    private Game model;

    public GameController(ArrayList<Player> players) {
        model = new Game(players);
        view = new GameBoardConsole();

        view.printPlayer(model.getCurrentPlayer());
        startGame();
    }

    private void startGame() {
        model.setGameStarted(true);
        while (model.getGameStarted()) {
            askCard();
        }
    }

    public void askCard() {
        // Ask card
        Scanner scanner = new Scanner(System.in);
        view.printAskCard();
        int choice = scanner.nextInt();

        // If we want a new card give one
        if (1 == choice) {
            getNewCard();
            return;
        }

        endPlayerMove();
    }

    public void getNewCard() {
        Card card = model.askCard();
        view.printDrawnCard(card);
        view.printPlayerCards(model.getCurrentPlayer().getCards(), model.getCurrentPlayer().getTotalCardValue());

        // If we got more then 21 then stop
        if (model.getCurrentPlayer().getTotalCardValue() > 21) {
            endPlayerMove();
        }
    }

    public void processGameResult() {
        switch (model.getGameResult()) {
            case BLACKJACK:
                view.printBlackjack(model.getCurrentPlayer());
                break;
            case STOPPED:
                view.printPlayerStopped(model.getCurrentPlayer());
                break;
            case LOST:
                view.printPlayerLost(model.getCurrentPlayer());
                break;
        }
    }

    public void endPlayerMove() {
        processGameResult();

        // Update the model
        Player player = model.endPlayerMove();

        if (null == player) {
            // Update the view
            view.printPlayer(model.getCurrentPlayer());
            return;
        }

        view.printWinner(player);
    }

    public GameBoardConsole getView() {
        return view;
    }

    public Game getModel() {
        return model;
    }
}
