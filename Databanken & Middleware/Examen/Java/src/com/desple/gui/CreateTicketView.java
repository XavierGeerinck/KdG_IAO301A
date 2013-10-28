package com.desple.gui;

import com.desple.model.*;
import com.desple.services.*;
import com.desple.util.SpringUtilities;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Xavier
 * Date: 26/10/13
 * Time: 19:05
 * To change this template use File | Settings | File Templates.
 */
public class CreateTicketView extends JFrame {
    private JButton btnOrder;
    private JLabel lblKoperNaam;
    private JTextField txtKoperNaam;
    private JLabel lblKoperType;
    private JComboBox<EKoperType> cmbKoperType;
    private JLabel lblFestivals;
    private JComboBox<Festival> cmbFestivals;
    private JLabel lblFestivalDagen;
    private JComboBox<FestivalDag> cmbFestivalDagen;
    private JLabel lblTicketTypes;
    private JComboBox<TicketType> cmbTicketTypes;
    private JLabel lblTicketOrders;
    private JComboBox<ETicketOrder> cmbTicketOrders;
    private JLabel lblAmountOfTickets;
    private JTextField txtAmountOfTickets;

    public CreateTicketView() {
        setTitle("Create Ticket");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Center GUI

        initComponents();
        addComponents();
        addListeners();
        pack();
    }

    private void initComponents() {
        btnOrder = new JButton("Order");

        lblKoperNaam = new JLabel("Koper: ", JLabel.TRAILING);
        txtKoperNaam = new JTextField(10);
        lblKoperNaam.setLabelFor(txtKoperNaam);

        lblKoperType = new JLabel("KoperType: ", JLabel.TRAILING);
        cmbKoperType = new JComboBox<EKoperType>();

        for (EKoperType kt : EKoperType.values())  {
            cmbKoperType.addItem(kt);
        }

        lblKoperType.setLabelFor(cmbTicketTypes);

        lblAmountOfTickets = new JLabel("Amount Of Tickets: ", JLabel.TRAILING);
        txtAmountOfTickets = new JTextField(10);
        lblAmountOfTickets.setLabelFor(txtAmountOfTickets);

        // Festival Dropdown
        lblFestivals = new JLabel("Festival: ", JLabel.TRAILING);
        cmbFestivals = new JComboBox<Festival>();

        // Get festivals
        for (Festival f : FestivalService.getFestivals()) {
            cmbFestivals.addItem(f);
        }

        lblFestivals.setLabelFor(cmbFestivals);

        // Festival dagen
        lblFestivalDagen = new JLabel("Festival Dag: ", JLabel.TRAILING);
        cmbFestivalDagen = new JComboBox<FestivalDag>();

        for (FestivalDag fd : FestivalDagService.getFestivalDagen((Festival) cmbFestivals.getSelectedItem())) {
            cmbFestivalDagen.addItem(fd);
        }

        lblFestivalDagen.setLabelFor(cmbFestivalDagen);

        // Ticket Type
        lblTicketTypes = new JLabel("Ticket Types: ", JLabel.TRAILING);
        cmbTicketTypes = new JComboBox<TicketType>();

        for (TicketType tp : TicketTypeService.getTicketTypes((Festival) cmbFestivals.getSelectedItem())) {
            cmbTicketTypes.addItem(tp);
        }

        lblTicketTypes.setLabelFor(cmbTicketTypes);

        // Ticket Orders
        lblTicketOrders = new JLabel("Order Type: ", JLabel.TRAILING);
        cmbTicketOrders = new JComboBox<ETicketOrder>();

        for (ETicketOrder to : ETicketOrder.values()) {
            cmbTicketOrders.addItem(to);
        }

        lblTicketOrders.setLabelFor(cmbTicketOrders);
    }

    private void addComponents() {
        // Create spring layout
        JPanel p = new JPanel(new SpringLayout());

        p.add(lblFestivals);
        p.add(cmbFestivals);
        p.add(lblFestivalDagen);
        p.add(cmbFestivalDagen);
        p.add(lblTicketTypes);
        p.add(cmbTicketTypes);
        p.add(lblKoperNaam);
        p.add(txtKoperNaam);
        p.add(lblKoperType);
        p.add(cmbKoperType);
        p.add(lblTicketOrders);
        p.add(cmbTicketOrders);
        p.add(lblAmountOfTickets);
        p.add(txtAmountOfTickets);

        // Layout the panel
        // makeCompactGrid(panel, rows, cols, initX, initY, paddingX, paddingY
        SpringUtilities.makeCompactGrid(p, 7, 2, 5, 5, 5, 5);

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

    private void addListeners() {
        // On pressing order
        btnOrder.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if everything is set
                if (txtKoperNaam.getText().equals("") || cmbKoperType.getSelectedItem() == null
                        || txtAmountOfTickets.getText().equals("")
                        || cmbTicketTypes.getSelectedItem() == null || cmbFestivalDagen.getSelectedItem() == null
                        || cmbFestivals.getSelectedItem() == null) {
                    JOptionPane.showMessageDialog(getContentPane(), "Invalid details entered", "Invalid Details", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Create a new ticket koper
                    Koper koper = new Koper();
                    koper.setNaam(txtKoperNaam.getText());
                    koper.setType((EKoperType) cmbKoperType.getSelectedItem());

                    TicketOrder ticketOrder = new TicketOrder();
                    ticketOrder.setKoper(koper);
                    ticketOrder.setVerkoopsWijze((ETicketOrder) cmbTicketOrders.getSelectedItem());

                    ArrayList<Ticket> tickets = new ArrayList();

                    for (int i = 0; i < (int)Integer.parseInt(txtAmountOfTickets.getText()); i++) {
                        Ticket ticket = new Ticket();
                        ticket.setTicketType((TicketType) cmbTicketTypes.getSelectedItem());
                        ticket.setTicketOrder(ticketOrder);
                        ticket.setFestivalDag((FestivalDag)cmbFestivalDagen.getSelectedItem());
                        ticket.setBarcode("8711700735178");

                        tickets.add(ticket);
                    }

                    // Save tickets
                    try {
                        VerkoopService.registerOrder(koper, ticketOrder, tickets);

                        JOptionPane.showMessageDialog(getContentPane(), "Created " + txtAmountOfTickets.getText() + " tickets.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(getContentPane(), ex.getMessage(), "Invalid Details", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // When we select a festival, update the festival dagen
        cmbFestivals.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Update festival dagen
                cmbFestivalDagen.removeAllItems();

                for (FestivalDag fd : FestivalDagService.getFestivalDagen((Festival) cmbFestivals.getSelectedItem())) {
                    cmbFestivalDagen.addItem(fd);
                }

                // Update ticket types
                cmbTicketTypes.removeAllItems();

                for (TicketType tt : TicketTypeService.getTicketTypes((Festival) cmbTicketTypes.getSelectedItem())) {
                    cmbTicketTypes.addItem(tt);
                }
            }
        });
    }
}
