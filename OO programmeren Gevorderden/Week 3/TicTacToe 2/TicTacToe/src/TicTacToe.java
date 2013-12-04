import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.JFrame;

/**
 * Classic Tic Tac Toe example in java.
 * Uses Java GUI
 *
 * @author WolfCoder
 * @author 11-08-2007
 */
public class TicTacToe extends JFrame {
    /**
     * This is a Canvas where the game is drawn on.
     * This is also where the game data resides.
     */
    private static class GameBoard extends Canvas {
        private static final int EMPTY = 0, X_PIECE = 1, O_PIECE = 2;
        private int[][] gameGrid = new int[3][3]; // Game grid
        private boolean xTurn; // Is it X's turn?
        private Random random; // Random generator
        private boolean gameRunning; // Is a game in progress?
        private int gameResult; // Result of game

        /**
         * Handles mouse input in the window.
         */
        private class GameListener implements MouseListener {
            public void mousePressed(MouseEvent e) {
            }

            public void mouseClicked(MouseEvent e) {
                // Check the location of the click
                int xPos = e.getPoint().x;
                int yPos = e.getPoint().y;
                // Check to see if it is in game board
                if (xPos > 50 && yPos > 50 && xPos < 50 + 50 * 3 && yPos < 50 + 50 * 3) {
                    // Check to see if game is running
                    if (gameRunning == false) {
                        // New game
                        wipeGrid();
                        gameRunning = true;
                        repaint();
                        return;
                    }
                    // Check for an empty place
                    if (gameGrid[xPos / 50 - 1][yPos / 50 - 1] != EMPTY)
                        return; // Not empty, can't place piece
                    // Place a piece for the current turn and then alternate
                    if (xTurn) {
                        gameGrid[xPos / 50 - 1][yPos / 50 - 1] = X_PIECE;
                        xTurn = false;
                    } else {
                        gameGrid[xPos / 50 - 1][yPos / 50 - 1] = O_PIECE;
                        xTurn = true;
                    }
                    // Check for a winning game
                    gameResult = gameOver();
                    if (gameResult != 0) {
                        // Game has ended!
                        gameRunning = false;
                    }
                    // Cause an update
                    repaint();
                }
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }
        }

        /**
         * Creates a new game board.
         */
        public GameBoard() {
            // Set the size and background color
            setPreferredSize(new Dimension(256, 256));
            setBackground(Color.WHITE);
            // Add mouse listener
            addMouseListener(new GameListener());
            // Create a new random
            random = new Random();
            // Wipe grid
            wipeGrid();
            // Set game status
            gameRunning = true;
        }

        /**
         * Clears the game board of all pieces.
         * This function also sets a random turn for the next player.
         */
        public void wipeGrid() {
            // Wipes the entire grid
            for (int y = 0; y < 3; y++)
                for (int x = 0; x < 3; x++)
                    gameGrid[x][y] = EMPTY;
            // Set player
            if (random.nextInt(100) < 50)
                xTurn = true;
            else
                xTurn = false;
        }

        /**
         * Checks to see if the game is over.
         *
         * @return If the game is over or not. 0 = Not over, 1 = X wins, 2 = O wins, 3 = tie
         */
        int gameOver() {
            // Check for a match
            for (int x = 0; x < 3; x++) // Rows
                if (gameGrid[x][0] == gameGrid[x][1] && gameGrid[x][1] == gameGrid[x][2])
                    return gameGrid[x][0];
            for (int y = 0; y < 3; y++) // Columns
                if (gameGrid[0][y] == gameGrid[1][y] && gameGrid[1][y] == gameGrid[2][y])
                    return gameGrid[0][y];
            // Diagonal 1
            if (gameGrid[0][0] == gameGrid[1][1] && gameGrid[1][1] == gameGrid[2][2])
                return gameGrid[0][0];
            if (gameGrid[2][0] == gameGrid[1][1] && gameGrid[0][2] == gameGrid[1][1])
                return gameGrid[2][0];
            // Check for tie
            for (int y = 0; y < 3; y++)
                for (int x = 0; x < 3; x++)
                    if (gameGrid[x][y] == 0)
                        return 0; // Not a tie because there is an empty space
            // The game is a tie
            return 3;
        }

        /**
         * Paints the game board.
         */
        public void paint(Graphics g) {
            // Clear old stuff out
            g.clearRect(0, 0, getWidth(), getHeight());
            // Draw lines
            g.setColor(Color.BLACK);
            for (int y = 1; y < 3; y++)
                g.drawLine(50, y * 50 + 50, 50 + 50 * 3, y * 50 + 50);
            for (int x = 1; x < 3; x++)
                g.drawLine(x * 50 + 50, 50, x * 50 + 50, 50 + 50 * 3);
            // Draw pieces
            for (int y = 0; y < 3; y++) {
                for (int x = 0; x < 3; x++) {
                    if (gameGrid[x][y] == X_PIECE) {
                        g.setColor(Color.BLUE);
                        g.drawLine(50 + x * 50, 50 + y * 50, 50 + x * 50 + 50, 50 + y * 50 + 50);
                        g.drawLine(50 + 50 + x * 50, 50 + y * 50, 50 + x * 50, 50 + y * 50 + 50);
                    }
                    if (gameGrid[x][y] == O_PIECE) {
                        g.setColor(Color.RED);
                        g.drawOval(50 + x * 50, 50 + y * 50, 50, 50);
                    }
                }
            }
            // Check for turns
            g.setColor(Color.BLACK);
            if (gameRunning) {
                // Turn message
                if (xTurn)
                    g.drawString("It is player X's turn.", 10, 20);
                else
                    g.drawString("It is player O's turn.", 10, 20);
            } else {
                // End message
                if (gameResult == X_PIECE)
                    g.drawString("Player X won!", 10, 20);
                if (gameResult == O_PIECE)
                    g.drawString("Player O won!", 10, 20);
                if (gameResult == 3)
                    g.drawString("Tie game!", 10, 20);
                // Prompt message
                g.drawString("Click to start a new game.", 10, 40);
            }
        }
    }

    /**
     * Starts the game of Tic Tac Toe.
     *
     * @param args This is ignored.
     */
    public static void main(String[] args) {
        // Create the window for tic tac toe
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.setTitle("Tic Tac Toe");
        ticTacToe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Add the game board
        GameBoard gameBoard = new GameBoard();
        ticTacToe.add(gameBoard);
        // Pack and show
        ticTacToe.pack();
        ticTacToe.setLocationRelativeTo(null);
		ticTacToe.setVisible(true);
	}
}
