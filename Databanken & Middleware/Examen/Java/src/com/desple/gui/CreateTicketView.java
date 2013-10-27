package com.desple.gui;

import com.desple.model.*;
import com.desple.services.*;
import com.desple.util.SpringUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JTextField txtKoperType;
    private JLabel lblFestivals;
    private JComboBox<Festival> cmbFestivals;
    private JLabel lblFestivalDagen;
    private JComboBox<FestivalDag> cmbFestivalDagen;
    private JLabel lblTicketTypes;
    private JComboBox<TicketType> cmbTicketTypes;

    public CreateTicketView() {
        setTitle("Create Ticket");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        txtKoperType = new JTextField(10);
        lblKoperType.setLabelFor(txtKoperType);

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
        lblTicketTypes = new JLabel("Ticket Types", JLabel.TRAILING);
        cmbTicketTypes = new JComboBox<TicketType>();

        for (TicketType tp : TicketTypeService.getTicketTypes((Festival) cmbFestivals.getSelectedItem())) {
            cmbTicketTypes.addItem(tp);
        }

        lblTicketTypes.setLabelFor(cmbTicketTypes);
    }

    private void addComponents() {
        // Create spring layout
        JPanel p = new JPanel(new SpringLayout());

        p.add(lblFestivals);
        p.add(cmbFestivals);
        p.add(lblFestivalDagen);
        p.add(cmbFestivalDagen);
        p.add(lblTicketTypes);
        p.add(cmbTicketTypes);;
        p.add(lblKoperNaam);
        p.add(txtKoperNaam);
        p.add(lblKoperType);
        p.add(txtKoperType);

        // Layout the panel
        // makeCompactGrid(panel, rows, cols, initX, initY, paddingX, paddingY
        SpringUtilities.makeCompactGrid(p, 9, 2, 5, 5, 5, 5);

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
                // Create a new ticket koper
                Koper koper = new Koper();
                koper.setNaam(txtKoperNaam.getText());
                koper.setType(txtKoperType.getText());

                TicketOrder ticketOrder = new TicketOrder();
                ticketOrder.setKoper(koper);
                ticketOrder.setVerkoopsWijze("Manual Added");

                Ticket ticket = new Ticket();
                ticket.setTicketType((TicketType) cmbTicketTypes.getSelectedItem());
                ticket.setTicketOrder(ticketOrder);
                ticket.setFestivalDag((FestivalDag)cmbFestivalDagen.getSelectedItem());
                ticket.setBarcode("8711700735178");



                /*ticket.setSoort();
                ticket.setTicketOrder();
                ticket.setTicketType();
                VerkoopService.registerOrder();  */
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
