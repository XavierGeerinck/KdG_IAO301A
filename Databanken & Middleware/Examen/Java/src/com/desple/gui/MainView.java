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
    private JButton btnPassageView;
    private JButton btnSearchFestivalsView;
    private JButton btnSearchOptredenView;

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
        btnPassageView = new JButton("Passage View");
        btnSearchFestivalsView = new JButton("Search Festival");
        btnSearchOptredenView = new JButton("Search Optredens");
    }

    private void addComponents() {
        JPanel pMain = new JPanel();
        pMain.setLayout(new GridLayout(0, 2));

        // Add the spring layour and the button
        pMain.setOpaque(true);
        pMain.add(btnCreateTicket);
        pMain.add(btnPassageView);
        pMain.add(btnSearchFestivalsView);
        pMain.add(btnSearchOptredenView);

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

        btnPassageView.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            CreatePassageView cpv = new CreatePassageView();
            cpv.setVisible(true);
            }
        });

        btnSearchFestivalsView.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SearchFestivalsView sfv = new SearchFestivalsView();
                sfv.setVisible(true);
            }
        });

        btnSearchOptredenView.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SearchOptredenView sov = new SearchOptredenView();
                sov.setVisible(true);
            }
        });
    }
}
