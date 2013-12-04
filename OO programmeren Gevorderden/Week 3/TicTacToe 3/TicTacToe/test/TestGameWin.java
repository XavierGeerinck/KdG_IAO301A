import controller.GameController;
import junit.framework.TestCase;
import model.GameModel;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import view.GameBoard;
import view.MainFrame;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by xaviergeerinck on 27/11/13.
 */
public class TestGameWin {
    private GameModel model = new GameModel();

    @Test
    public void startGame() {
        // Game should be running
        assertTrue(model.isGameRunning());

        // Empty board
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                assertEquals(model.getGameGrid()[x][y], model.EMPTY);
            }
        }
    }

    @Test
    public void doWin() {
        model.setXTurn(false); // Start with O for the tests

        // Move O1
        assertFalse(model.isxTurn());

        int x = 71;
        int y = 76;

        doPlayerClick(x, y);

        assertTrue(model.isGameRunning());

        // Move X1
        assertTrue(model.isxTurn());

        x = 73;
        y = 122;

        doPlayerClick(x, y);

        assertTrue(model.isGameRunning());

        // Move O2
        assertFalse(model.isxTurn());

        x = 118;
        y = 80;

        doPlayerClick(x, y);

        assertTrue(model.isGameRunning());

        // Move X2
        assertTrue(model.isxTurn());

        x = 126;
        y = 130;

        doPlayerClick(x, y);

        assertTrue(model.isGameRunning());

        // Move O3 and win the game
        assertFalse(model.isxTurn());

        x = 191;
        y = 74;

        doPlayerClick(x, y);

        assertFalse(model.isGameRunning());
        assertEquals(model.getGameResult(), model.O_PIECE);
    }

    public void doPlayerClick(int xPos, int yPos) {
        if (model.inGameBoard(xPos, yPos)) {
            doGameTurn(xPos, yPos);
        }
    }

    private void doGameTurn(int xPos, int yPos) {
        System.out.println("X: " + xPos + "Y: " + yPos);
        // Check to see if game is running
        if (!model.isGameRunning()) {
            model.wipeGrid();
            model.setGameRunning(true);
            return;
        }
        // Check for an empty place
        if (model.isEmptyPlace(xPos, yPos)) {
            return; // Not empty, can't place piece
        }

        // Place a piece for the current turn and then alternate
        model.doMove(xPos, yPos);

        // Check for a winning game
        model.checkWinningGame();
    }
}
