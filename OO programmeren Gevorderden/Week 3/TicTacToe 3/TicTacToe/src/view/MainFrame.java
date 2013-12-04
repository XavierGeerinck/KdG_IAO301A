package view;

import javax.swing.*;

/**
 * Created by xaviergeerinck on 27/11/13.
 */
public class MainFrame extends JFrame {
    public MainFrame(GameBoard board) {
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(board);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
