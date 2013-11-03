package com.desple.gui;

import com.desple.model.*;
import com.desple.services.*;
import com.desple.util.SpringUtilities;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Xavier
 * Date: 26/10/13
 * Time: 19:05
 * To change this template use File | Settings | File Templates.
 */
public class CreatePassageView extends JFrame {
    private JButton btnIn;
    private JButton btnOut;
    private JLabel lblFestivals;
    private JComboBox<Festival> cmbFestivals;
    private JLabel lblFestivalDagen;
    private JComboBox<FestivalDag> cmbFestivalDagen;
    private JLabel lblZones;
    private JComboBox<Zone> cmbZones;
    private JLabel lblRfidBand;
    private JTextField txtRfidBand;

    private Date dateIn;
    private Date dateOut;

    public CreatePassageView() {
        setTitle("Create Passage");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Center GUI

        initComponents();
        addComponents();
        addListeners();
        pack();
    }

    private void initComponents() {
        btnIn = new JButton("Passage In");
        btnOut = new JButton("Passage Out");

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
        lblZones = new JLabel("Zones: ", JLabel.TRAILING);
        cmbZones = new JComboBox<Zone>();

        for (Zone z : ZoneService.getZonesByFestival((Festival) cmbFestivals.getSelectedItem())) {
            cmbZones.addItem(z);
        }

        lblZones.setLabelFor(cmbZones);

        // Ticket Type
        lblRfidBand = new JLabel("Rfid: ", JLabel.TRAILING);
        txtRfidBand = new JTextField(10);
        lblRfidBand.setLabelFor(lblRfidBand);
    }

    private void addComponents() {
        // Create spring layout
        JPanel p = new JPanel(new SpringLayout());

        p.add(lblFestivals);
        p.add(cmbFestivals);
        p.add(lblFestivalDagen);
        p.add(cmbFestivalDagen);
        p.add(lblZones);
        p.add(cmbZones);
        p.add(lblRfidBand);
        p.add(txtRfidBand);

        // Layout the panel
        // makeCompactGrid(panel, rows, cols, initX, initY, paddingX, paddingY
        SpringUtilities.makeCompactGrid(p, 4, 2, 5, 5, 5, 5);

        p.setOpaque(true);

        // Main
        JPanel pMain = new JPanel();
        pMain.setLayout(new BoxLayout(pMain, BoxLayout.PAGE_AXIS));

        // Add the spring layour and the button
        pMain.setOpaque(true);
        pMain.add(p);
        pMain.add(btnIn);
        pMain.add(btnOut);

        setContentPane(pMain);
    }

    private void addListeners() {
        // On pressing order
        btnOut.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dateOut = new Date();
                createPassage();
            }
        });

        // On pressing order
        btnIn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dateIn = new Date();
                createPassage();
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
                cmbZones.removeAllItems();

                for (Zone z : ZoneService.getZonesByFestival((Festival) cmbFestivals.getSelectedItem())) {
                    cmbZones.addItem(z);
                }
            }
        });
    }

    private void createPassage() {
        // Check if everything is set
        if (txtRfidBand.getText().equals("") ||  cmbFestivalDagen.getSelectedItem() == null
                || cmbFestivals.getSelectedItem() == null || cmbZones.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(getContentPane(), "Invalid details entered", "Invalid Details", JOptionPane.ERROR_MESSAGE);
        } else if(dateIn == null && dateOut != null) {
            JOptionPane.showMessageDialog(getContentPane(), "First create an In tracking then an out", "Invalid details entered", JOptionPane.ERROR_MESSAGE);
        } else {
            // Create a new tracking
            Tracking tracking = new Tracking();
            tracking.setZone((Zone) cmbZones.getSelectedItem());
            tracking.setTimestampIn(dateIn);
            tracking.setTimestampOut(dateOut);

            // Save Tracking
            try {
                TrackingService.savePassage(tracking);

                JOptionPane.showMessageDialog(getContentPane(), "Created in:" + tracking.getTimestampIn() + " out: " + tracking.getTimestampOut() + "for rfid: " + txtRfidBand.getText(), "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(getContentPane(), ex.getMessage(), "Invalid Details", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
