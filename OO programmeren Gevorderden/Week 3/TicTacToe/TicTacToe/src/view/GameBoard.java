package view;

import controller.GameController;
import model.GameModel;
import view.listener.GameListener;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

/**
 * This is a Canvas where the game is drawn on.
 * This is also where the game data resides.
 */
public class GameBoard extends Canvas {
    private int[][] gameGrid;
    private boolean isGameRunning;
    private boolean isXTurn;
    private int gameResult;

    /**
     * Creates a new game board.
     */
    public GameBoard() {
        gameGrid = new int[3][3];
        isGameRunning = true;
        isXTurn = false;
        gameResult = GameModel.EMPTY;

        // Set the size and background color
        setPreferredSize(new Dimension(256, 256));
        setBackground(Color.WHITE);
    }

    /**
     * Paints the game board.
     */
    public void paint(Graphics g) {
        // Clear old stuff out
        g.clearRect(0, 0, getWidth(), getHeight());

        // Draw
        drawGrid(g);
        drawPieces(g, gameGrid);
        drawTurn(g);
    }

    private void drawTurn(Graphics g) {
        g.setColor(Color.BLACK);

        if (isGameRunning) {
            drawTurn(g, isXTurn);
        } else {
            drawGameResult(g);
        }
    }

    private void drawGameResult(Graphics g) {
        switch(gameResult) {
            case GameModel.X_PIECE:
                g.drawString("Player X won!", 10, 20);
                break;
            case GameModel.O_PIECE:
                g.drawString("Player O won!", 10, 20);
                break;
            case 3:
                g.drawString("Tie game!", 10, 20);
                break;
            default:
                g.drawString("Click to start a new game.", 10, 40);
        }
    }

    private void drawTurn(Graphics g, boolean isXTurn) {
        if (isXTurn) {
            g.drawString("It is player X's turn.", 10, 20);
        } else {
            g.drawString("It is player O's turn.", 10, 20);
        }
    }

    private void drawGrid(Graphics g) {
        g.setColor(Color.BLACK);

        for (int y = 1; y < 3; y++) {
            g.drawLine(50, y * 50 + 50, 50 + 50 * 3, y * 50 + 50);
        }

        for (int x = 1; x < 3; x++) {
            g.drawLine(x * 50 + 50, 50, x * 50 + 50, 50 + 50 * 3);
        }
    }

    private void drawPieces(Graphics g, int[][] gameGrid) {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                drawXPiece(g, gameGrid, x, y);
                drawOPiece(g, gameGrid, x, y);
            }
        }
    }

    private void drawXPiece(Graphics g, int[][] gameGrid, int x, int y) {
        if (isXPiece(gameGrid, x, y)) {
            g.setColor(Color.BLUE);
            g.drawLine(50 + x * 50, 50 + y * 50, 50 + x * 50 + 50, 50 + y * 50 + 50);
            g.drawLine(50 + 50 + x * 50, 50 + y * 50, 50 + x * 50, 50 + y * 50 + 50);
        }
    }

    private void drawOPiece(Graphics g, int[][] gameGrid, int x, int y) {
        if (isOPiece(gameGrid, x, y)) {
            g.setColor(Color.RED);
            g.drawOval(50 + x * 50, 50 + y * 50, 50, 50);
        }
    }

    private boolean isXPiece(int[][] gameGrid, int x, int y) {
        return gameGrid[x][y] == GameModel.X_PIECE;
    }

    private boolean isOPiece(int[][] gameGrid, int x, int y) {
        return gameGrid[x][y] == GameModel.O_PIECE;
    }

    public int[][] getGameGrid() {
        return gameGrid;
    }

    public void setGameGrid(int[][] gameGrid) {
        this.gameGrid = gameGrid;
    }

    public boolean isGameRunning() {
        return isGameRunning;
    }

    public void setGameRunning(boolean isGameRunning) {
        this.isGameRunning = isGameRunning;
    }

    public boolean isXTurn() {
        return isXTurn;
    }

    public void setXTurn(boolean isXTurn) {
        this.isXTurn = isXTurn;
    }

    public int getGameResult() {
        return gameResult;
    }

    public void setGameResult(int gameResult) {
        this.gameResult = gameResult;
    }
}
