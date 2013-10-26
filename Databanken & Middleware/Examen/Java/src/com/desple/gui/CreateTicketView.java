package com.desple.gui;

import com.desple.util.SpringUtilities;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Xavier
 * Date: 26/10/13
 * Time: 19:05
 * To change this template use File | Settings | File Templates.
 */
public class CreateTicketView extends JFrame {
    private JButton btnOrder;
    private JLabel lblSoort;
    private JTextField txtSoort;
    private JLabel lblFestDag;
    private JTextField txtFestDag;
    private JLabel lblKoperNaam;
    private JTextField txtKoperNaam;
    private JLabel lblKoperType;
    private JTextField txtKoperType;

    public CreateTicketView() {
        setTitle("Create Ticket");
        setSize(new Dimension(400, 300));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center GUI

        initComponents();
        addComponents();
        pack();
    }

    private void initComponents() {
        btnOrder = new JButton("Order");

        lblSoort = new JLabel("Soort: ", JLabel.TRAILING);
        txtSoort = new JTextField(10);
        lblSoort.setLabelFor(txtSoort);

        lblFestDag = new JLabel("Dag: ", JLabel.TRAILING);
        txtFestDag = new JTextField(10);
        lblFestDag.setLabelFor(txtFestDag);

        lblKoperNaam = new JLabel("Koper: ", JLabel.TRAILING);
        txtKoperNaam = new JTextField(10);
        lblKoperNaam.setLabelFor(txtKoperNaam);

        lblKoperType = new JLabel("KoperType: ", JLabel.TRAILING);
        txtKoperType = new JTextField(10);
        lblKoperType.setLabelFor(txtKoperType);
    }

    private void addComponents() {
        // Create spring layout
        JPanel p = new JPanel(new SpringLayout());

        p.add(lblSoort);
        p.add(txtSoort);
        p.add(lblFestDag);
        p.add(txtFestDag);
        p.add(lblKoperNaam);
        p.add(txtKoperNaam);
        p.add(lblKoperType);
        p.add(txtKoperType);

        // Layout the panel
        // makeCompactGrid(panel, rows, cols, initX, initY, paddingX, paddingY
        SpringUtilities.makeCompactGrid(p, 4, 2, 6, 6, 6, 6);

        p.setOpaque(true);

        // Main
        JPanel pMain = new JPanel();
        pMain.setLayout(new BoxLayout(pMain, BoxLayout.PAGE_AXIS));

        // Add the spring layour and the button
        pMain.setOpaque(true);
        pMain.add(p);
        pMain.add(btnOrder);

        setContentPane(pMain);
    }
}
