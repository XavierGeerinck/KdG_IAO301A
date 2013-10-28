package com.desple.gui;

import com.desple.model.*;
import com.desple.services.*;
import com.desple.util.SpringUtilities;
import net.sourceforge.jdatepicker.DateModel;
import net.sourceforge.jdatepicker.JDateComponent;
import net.sourceforge.jdatepicker.JDateComponentFactory;
import net.sourceforge.jdatepicker.JDatePicker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Xavier
 * Date: 26/10/13
 * Time: 19:05
 * To change this template use File | Settings | File Templates.
 */
public class SearchFestivalsView extends JFrame {
    private JButton btnSearch;
    private JLabel lblArtiesten;
    private JComboBox<Artiest> cmbArtiesten;
    private JLabel lblDatePicker1;
    private JDatePicker datePicker1;
    private JLabel lblDatePicker2;
    private JDatePicker datePicker2;

    public SearchFestivalsView() {
        setTitle("Search Optreden");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Center GUI

        initComponents();
        addComponents();
        addListeners();
        pack();
    }

    private void initComponents() {
        btnSearch = new JButton("Search Festival");

        // Festival Dropdown
        lblArtiesten = new JLabel("Artiest: ", JLabel.TRAILING);
        cmbArtiesten = new JComboBox<Artiest>();

        // Get festivals
        for (Artiest a : ArtiestService.getArtists()) {
            cmbArtiesten.addItem(a);
        }

        lblArtiesten.setLabelFor(cmbArtiesten);

        // Date picker 1
        lblDatePicker1 = new JLabel("Date 1: ", JLabel.TRAILING);

        datePicker1 = JDateComponentFactory.createJDatePicker();
        datePicker1.setTextEditable(true);
        datePicker1.setShowYearButtons(true);

        lblDatePicker1.setLabelFor((JComponent) datePicker1);

        // Date picker 2
        lblDatePicker2 = new JLabel("Date 2: ", JLabel.TRAILING);
        datePicker2 = JDateComponentFactory.createJDatePicker();
        datePicker2.setTextEditable(true);
        datePicker2.setShowYearButtons(true);

        lblDatePicker2.setLabelFor((JComponent) datePicker2);
    }

    private void addComponents() {
        // Create spring layout
        JPanel p = new JPanel(new SpringLayout());

        p.add(lblArtiesten);
        p.add(cmbArtiesten);
        p.add(lblDatePicker1);
        p.add((JComponent) datePicker1);
        p.add(lblDatePicker2);
        p.add((JComponent) datePicker2);

        // Layout the panel
        // makeCompactGrid(panel, rows, cols, initX, initY, paddingX, paddingY
        SpringUtilities.makeCompactGrid(p, 3, 2, 5, 5, 5, 5);

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
                if (cmbArtiesten.getSelectedItem() == null) {
                    JOptionPane.showMessageDialog(getContentPane(), "Invalid details entered", "Invalid Details", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Search Festivals
                    try {
                        // Dates
                        GregorianCalendar calendar1 = (GregorianCalendar) datePicker1.getModel().getValue();
                        GregorianCalendar calendar2 = (GregorianCalendar) datePicker2.getModel().getValue();

                        // Get optredens that are happening now.
                        List<Festival> festivals = FestivalService.findFestivalByArtistAndDate((Artiest) cmbArtiesten.getSelectedItem(), calendar1.getTime(), calendar2.getTime());

                        StringBuilder sb = new StringBuilder();

                        sb.append("Found Festivals: ");

                        if (festivals.isEmpty()) {
                            sb.append("none");
                        } else {
                            for (Festival f : festivals) {
                                sb.append(f.getNaam());
                            }
                        }

                        JOptionPane.showMessageDialog(getContentPane(), sb.toString(), "Success", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(getContentPane(), ex.getMessage(), "Invalid Details", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }
}
