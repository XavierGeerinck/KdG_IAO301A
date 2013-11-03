package com.desple.gui;

import com.desple.model.*;
import com.desple.services.*;
import com.desple.util.SpringUtilities;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Xavier
 * Date: 26/10/13
 * Time: 19:05
 * To change this template use File | Settings | File Templates.
 */
public class SearchOptredenView extends JFrame {
    private JButton btnSearch;
    private JLabel lblFestivals;
    private JComboBox<Festival> cmbFestivals;
    private JLabel lblFestivalDagen;
    private JComboBox<FestivalDag> cmbFestivalDagen;
    private JLabel lblZones;
    private JComboBox<Zone> cmbZones;
    private ArrayList<Zone> zones = new ArrayList<Zone>();
    private JLabel lblTimePicker;
    private JSpinner spinTimePicker;

    public SearchOptredenView() {
        setTitle("Search Optreden");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Center GUI

        initComponents();
        addComponents();
        addListeners();
        pack();
    }

    private void initComponents() {
        btnSearch = new JButton("Search Optreden");

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
            zones.add(z);
        }

        lblZones.setLabelFor(cmbZones);

        // Time Picker
        lblTimePicker = new JLabel("Time: ", JLabel.TRAILING);
        spinTimePicker = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(spinTimePicker, "HH:mm:ss");
        spinTimePicker.setEditor(timeEditor);
        spinTimePicker.setValue(new Date());
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
        p.add(lblTimePicker);
        p.add(spinTimePicker);

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
        pMain.add(btnSearch);

        setContentPane(pMain);
    }

    private void addListeners() {
        // On pressing order
        btnSearch.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if everything is set
                if (cmbFestivalDagen.getSelectedItem() == null || cmbFestivals.getSelectedItem() == null || cmbZones.getSelectedItem() == null) {
                    JOptionPane.showMessageDialog(getContentPane(), "Invalid details entered", "Invalid Details", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Search Optreden
                    try {
                        // Get the selected festivalDag, we need this to get the date
                        Date festivalDagDate = ((FestivalDag) cmbFestivalDagen.getSelectedItem()).getDatum();
                        Calendar calFestivalDag = Calendar.getInstance();
                        calFestivalDag.setTime(festivalDagDate);

                        // Get optredens that are happening now.
                        Date timePicked = (Date) spinTimePicker.getValue();

                        // Change the day, month and year of the spinner to the one of the selected festival day
                        Calendar cal = Calendar.getInstance();
                        cal.setTime(timePicked);
                        cal.set(Calendar.DAY_OF_MONTH, calFestivalDag.get(Calendar.DAY_OF_MONTH));
                        cal.set(Calendar.MONTH, calFestivalDag.get(Calendar.MONTH));
                        cal.set(Calendar.YEAR, calFestivalDag.get(Calendar.YEAR));

                        int index = cmbZones.getSelectedIndex();
                        // Search

                        JOptionPane.showMessageDialog(getContentPane(), zones.get(index).getId(), "Success", JOptionPane.INFORMATION_MESSAGE);
                        List<Optreden> optredens = OptredenService.findOptredenByDateAndZone(cal.getTime(), zones.get(index));

                        StringBuilder sb = new StringBuilder();

                        sb.append("Happening now: ");

                        if (optredens.isEmpty()) {
                            sb.append("none");
                        } else {

                            for (Optreden op : optredens) {
                                sb.append( op.getId() + " " + op.getArtiest().getNaam());
                            }
                        }

                        JOptionPane.showMessageDialog(getContentPane(), sb.toString(), "Success", JOptionPane.INFORMATION_MESSAGE);
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
                cmbZones.removeAllItems();
                zones.clear();

                for (Zone z : ZoneService.getZonesByFestival((Festival) cmbFestivals.getSelectedItem())) {
                    cmbZones.addItem(z);
                    zones.add(z);
                }
            }
        });
    }
}
