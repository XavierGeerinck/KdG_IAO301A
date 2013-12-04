package be.kdg.blackjack;

import be.kdg.blackjack.controller.GameController;
import be.kdg.blackjack.model.Player;

import java.util.ArrayList;

/**
 * Created by xaviergeerinck on 04/12/13.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>();
        Player player = new Player("Xavier");
        Player player2 = new Player("Computer");
        players.add(player);
        players.add(player2);

        GameController controller = new GameController(players);
    }
}
