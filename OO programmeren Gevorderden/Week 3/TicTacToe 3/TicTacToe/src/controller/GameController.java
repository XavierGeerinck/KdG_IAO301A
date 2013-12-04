package controller;

import model.GameModel;
import view.GameBoard;

/**
 * Created by xaviergeerinck on 27/11/13.
 */
public class GameController {
    private GameBoard view;
    private GameModel model;

    public GameController(GameModel model, GameBoard view) {
        this.view = view;
        this.model = model;

        view.setXTurn(model.isxTurn());
        view.setGameRunning(model.isGameRunning());
    }

    public void doPlayerClick(int xPos, int yPos) {
        if (model.inGameBoard(xPos, yPos)) {
            doGameTurn(xPos, yPos);
        }
    }

    private void doGameTurn(int xPos, int yPos) {
        // Check to see if game is running
        if (!model.isGameRunning()) {
            startNewGame();
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

        // Cause an update
        updateView();
    }

    public void startNewGame() {
        // New game
        model.wipeGrid();
        model.setGameRunning(true);
        updateView();
    }

    public int getGameResult() {
        return model.getGameResult();
    }

    public boolean isXTurn() {
        return model.isxTurn();
    }

    public boolean isXPiece(int x, int y) {
        return getGameGrid(x, y) == model.X_PIECE;
    }

    public boolean isOPiece(int x, int y) {
        return getGameGrid(x, y) == model.O_PIECE;
    }

    public boolean getGameRunning() {
        return model.isGameRunning();
    }

    public int getGameGrid(int x, int y) {
        return model.getGameGrid()[x][y];
    }

    public int[][] getGameGrid() {
        return model.getGameGrid();
    }

    public void updateView() {
        view.setGameRunning(getGameRunning());
        view.setGameResult(getGameResult());
        view.setGameGrid(getGameGrid());
        view.setXTurn(isXTurn());
        view.repaint();
    }
}
