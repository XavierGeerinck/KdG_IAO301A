import controller.GameController;
import model.GameModel;
import view.GameBoard;
import view.MainFrame;
import view.listener.GameListener;

import javax.swing.JFrame;

/**
 * Classic Tic Tac Toe example in java.
 * Uses Java GUI
 *
 * @author WolfCoder
 * @author 11-08-2007
 */
public class Main extends JFrame {

    /**
     * Starts the game of Tic Tac Toe.
     *
     * @param args This is ignored.
     */
    public static void main(String[] args) {
        // Model
        GameModel gameModel = new GameModel();

        // View
        GameBoard gameBoard = new GameBoard();
        MainFrame mainFrame = new MainFrame(gameBoard);

        // Controller
        GameController gameController = new GameController(gameModel, gameBoard);
        gameBoard.addMouseListener(new GameListener(gameController));
	}
}
