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
    private JLabel lblSoort;
    private JTextField txtSoort;
    private JLabel lblFestDag;
    private JTextField txtFestDag;
    private JLabel lblKoperNaam;
    private JTextField txtKoperNaam;
    private JLabel lblKoperType;
    private JTextField txtKoperType;
    private JLabel lblFest;
    private JTextField txtFest;
    private JLabel lblFestivals;
    private JComboBox<Festival> cmbFestivals;
    private JLabel lblFestivalDagen;
    private JComboBox<FestivalDag> cmbFestivalDagen;
    private JLabel lblZones;
    private JComboBox<Zone> cmbZones;
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

        lblSoort = new JLabel("Soort: ", JLabel.TRAILING);
        txtSoort = new JTextField(10);
        lblSoort.setLabelFor(txtSoort);

        lblFest = new JLabel("Festival: ", JLabel.TRAILING);
        txtFest = new JTextField();
        lblFest.setLabelFor(txtFest);

        lblFestDag = new JLabel("Festival Dag: ", JLabel.TRAILING);
        txtFestDag = new JTextField(10);
        lblFestDag.setLabelFor(txtFestDag);

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

        // Zones
        lblZones = new JLabel("Zones", JLabel.TRAILING);
        cmbZones = new JComboBox<Zone>();

        for (Zone z : ZoneService.getZonesByFestival((Festival) cmbFestivals.getSelectedItem())) {
            cmbZones.addItem(z);
        }

        lblZones.setLabelFor(cmbZones);

        // Ticket Type
        lblTicketTypes = new JLabel("Ticket Types", JLabel.TRAILING);
        cmbTicketTypes = new JComboBox<TicketType>();

        for (TicketType tp : TicketTypeService.getTicketTypes((Zone)cmbZones.getSelectedItem())) {
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
        p.add(lblSoort);
        p.add(txtSoort);
        p.add(lblFest);
        p.add(txtFest);
        p.add(lblFestDag);
        p.add(txtFestDag);
        p.add(lblKoperNaam);
        p.add(txtKoperNaam);
        p.add(lblKoperType);
        p.add(txtKoperType);

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
        btnOrder.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Get festival dag
                Ticket ticket = new Ticket();
                ticket.setFestivalDag((FestivalDag)cmbFestivalDagen.getSelectedItem());

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

                // Update zones
                cmbZones.removeAllItems();

                for (Zone z : ZoneService.getZonesByFestival((Festival) cmbFestivals.getSelectedItem())) {
                    cmbZones.addItem(z);
                }
            }
        });
    }
}
