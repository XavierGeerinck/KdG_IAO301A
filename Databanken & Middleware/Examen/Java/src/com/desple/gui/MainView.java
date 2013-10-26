package com.desple.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: Xavier
 * Date: 26/10/13
 * Time: 20:50
 * To change this template use File | Settings | File Templates.
 */
public class MainView extends JFrame {
    private JButton btnCreateTicket;

    public MainView() {
        setTitle("Festival App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center GUI

        initComponents();
        addComponents();
        addListeners();
        pack();
    }

    private void initComponents() {
        btnCreateTicket = new JButton("Create Ticket");
    }

    private void addComponents() {
        JPanel pMain = new JPanel();
        pMain.setLayout(new BoxLayout(pMain, BoxLayout.PAGE_AXIS));

        // Add the spring layour and the button
        pMain.setOpaque(true);
        pMain.add(btnCreateTicket);

        setContentPane(pMain);
    }

    private void addListeners() {
        btnCreateTicket.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                CreateTicketView ctv = new CreateTicketView();
                ctv.setVisible(true);
            }
        });
    }
}
