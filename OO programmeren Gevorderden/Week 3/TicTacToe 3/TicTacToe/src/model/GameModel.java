package model;

import controller.GameController;
import view.GameBoard;

import java.util.Random;

/**
 * Created by xaviergeerinck on 27/11/13.
 */
public class GameModel {
    public static final int EMPTY = 0, X_PIECE = 1, O_PIECE = 2;
    private int[][] gameGrid = new int[3][3]; // Game grid
    private boolean xTurn; // Is it X's turn?
    private Random random; // Random generator
    private boolean gameRunning; // Is a game in progress?
    private int gameResult; // Result of game

    public GameModel() {
        random = new Random();
        wipeGrid();
        gameRunning = true;
    }

    /**
     * Clears the game board of all pieces.
     * This function also sets a random turn for the next player.
     */
    public void wipeGrid() {
        // Wipes the entire grid
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                gameGrid[x][y] = EMPTY;
            }
        }

        // Set player
        xTurn = (random.nextInt(100) < 50);
    }

    /**
     * Checks to see if the game is over.
     *
     * @return If the game is over or not. 0 = Not over, 1 = X wins, 2 = O wins, 3 = tie
     */
    public int isGameOver() {
        // Check for a match
        for (int x = 0; x < 3; x++) {
            if (gameGrid[x][0] == gameGrid[x][1] && gameGrid[x][1] == gameGrid[x][2]) {
                return gameGrid[x][0];
            }
        }

        for (int y = 0; y < 3; y++) {
            if (gameGrid[0][y] == gameGrid[1][y] && gameGrid[1][y] == gameGrid[2][y]) {
                return gameGrid[0][y];
            }
        }

        // Diagonal 1
        if (gameGrid[0][0] == gameGrid[1][1] && gameGrid[1][1] == gameGrid[2][2]) {
            return gameGrid[0][0];
        }

        if (gameGrid[2][0] == gameGrid[1][1] && gameGrid[0][2] == gameGrid[1][1]) {
            return gameGrid[2][0];
        }

        // Check for tie
        return calculateGameResult();
    }

    private int calculateGameResult() {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (gameGrid[x][y] == 0) {
                    return 0; // Not a tie because there is an empty space
                }
            }
        }

        // Not a tie
        return 3;
    }

    public void newGame() {
        wipeGrid();
        setGameRunning(true);
    }

    public boolean inGameBoard(int xPos, int yPos) {
        return xPos > 50 && yPos > 50 && xPos < 50 + 50 * 3 && yPos < 50 + 50 * 3;
    }

    public void checkWinningGame() {
        setGameResult(isGameOver());

        if (getGameResult() != 0) {
            setGameRunning(false);
        }
    }

    public void doMove(int xPos, int yPos) {
        if (isxTurn()) {
            gameGrid[xPos / 50 - 1][yPos / 50 - 1] = X_PIECE;
            setXTurn(false);
        } else {
            gameGrid[xPos / 50 - 1][yPos / 50 - 1] = O_PIECE;
            setXTurn(true);
        }
    }

    public boolean isEmptyPlace(int xPos, int yPos) {
        return gameGrid[xPos / 50 - 1][yPos / 50 - 1] != EMPTY;
    }

    public int[][] getGameGrid() {
        return gameGrid;
    }

    public void setGameGrid(int[][] gameGrid) {
        this.gameGrid = gameGrid;
    }

    public boolean isxTurn() {
        return xTurn;
    }

    public void setXTurn(boolean xTurn) {
        this.xTurn = xTurn;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public boolean isGameRunning() {
        return gameRunning;
    }

    public void setGameRunning(boolean gameRunning) {
        this.gameRunning = gameRunning;
    }

    public int getGameResult() {
        return gameResult;
    }

    public void setGameResult(int gameResult) {
        this.gameResult = gameResult;
    }
}
