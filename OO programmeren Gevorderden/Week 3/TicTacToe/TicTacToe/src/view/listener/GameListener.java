package view.listener;

import controller.GameController;
import view.GameBoard;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by xaviergeerinck on 27/11/13.
 */
public class GameListener implements MouseListener {
    private GameController controller;

    public GameListener(GameController controller) {
        this.controller = controller;
    }

    public void mouseClicked(MouseEvent e) {
        // Check the location of the click
        int xPos = e.getPoint().x;
        int yPos = e.getPoint().y;

        controller.doPlayerClick(xPos, yPos);
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
}
