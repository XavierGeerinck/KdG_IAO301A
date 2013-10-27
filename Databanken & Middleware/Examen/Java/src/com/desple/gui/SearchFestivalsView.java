package com.desple.gui;

import com.desple.model.*;
import com.desple.services.*;
import com.desple.util.SpringUtilities;
import net.sourceforge.jdatepicker.DateModel;
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
        btnSearch = new JButton("Search Optreden");

        // Festival Dropdown
        lblArtiesten = new JLabel("Artiest: ", JLabel.TRAILING);
        cmbArtiesten = new JComboBox<Artiest>();

        // Get festivals
        for (Artiest a : ArtiestService.getArtists()) {
            cmbArtiesten.addItem(a);
        }

        lblArtiesten.setLabelFor(cmbArtiesten);
    }

    private void addComponents() {
        // Create spring layout
        JPanel p = new JPanel(new SpringLayout());

        p.add(lblArtiesten);
        p.add(cmbArtiesten);

        // Layout the panel
        // makeCompactGrid(panel, rows, cols, initX, initY, paddingX, paddingY
        SpringUtilities.makeCompactGrid(p, 1, 2, 5, 5, 5, 5);

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
                        /*JDatePicker jdp = new JDatePicker() {
                            @Override
                            public void setTextEditable(boolean b) {
                                //To change body of implemented methods use File | Settings | File Templates.
                            }

                            @Override
                            public boolean isTextEditable() {
                                return false;  //To change body of implemented methods use File | Settings | File Templates.
                            }

                            @Override
                            public void setButtonFocusable(boolean b) {
                                //To change body of implemented methods use File | Settings | File Templates.
                            }

                            @Override
                            public boolean getButtonFocusable() {
                                return false;  //To change body of implemented methods use File | Settings | File Templates.
                            }

                            @Override
                            public void setShowYearButtons(boolean b) {
                                //To change body of implemented methods use File | Settings | File Templates.
                            }

                            @Override
                            public boolean isShowYearButtons() {
                                return false;  //To change body of implemented methods use File | Settings | File Templates.
                            }

                            @Override
                            public void setDoubleClickAction(boolean b) {
                                //To change body of implemented methods use File | Settings | File Templates.
                            }

                            @Override
                            public boolean isDoubleClickAction() {
                                return false;  //To change body of implemented methods use File | Settings | File Templates.
                            }

                            @Override
                            public DateModel<?> getModel() {
                                return null;  //To change body of implemented methods use File | Settings | File Templates.
                            }

                            @Override
                            public void addActionListener(ActionListener actionListener) {
                                //To change body of implemented methods use File | Settings | File Templates.
                            }

                            @Override
                            public void removeActionListener(ActionListener actionListener) {
                                //To change body of implemented methods use File | Settings | File Templates.
                            }

                            @Override
                            public Properties getI18nStrings() {
                                return null;  //To change body of implemented methods use File | Settings | File Templates.
                            }

                            @Override
                            public void setI18nStrings(Properties properties) {
                                //To change body of implemented methods use File | Settings | File Templates.
                            }
                        }  */
                        // Dates
                        Date date1 = new Date();
                        Date date2 = new Date();

                        // TEST
                        GregorianCalendar calendar = new GregorianCalendar();
                        calendar.setTime(new Date());
                        calendar.add(Calendar.DATE, 10); // Add 10 days
                        date2.setTime(calendar.getTime().getTime());

                        // Get optredens that are happening now.
                        List<Festival> festivals = FestivalService.findFestivalByArtistAndDate((Artiest) cmbArtiesten.getSelectedItem(), date1, date2);

                        StringBuilder sb = new StringBuilder();

                        sb.append("Found Festivals: ");

                        for (Festival f : festivals) {
                            sb.append(f.getNaam());
                        }

                        JOptionPane.showMessageDialog(getContentPane(), sb.toString(), "Success", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(getContentPane(), ex.getMessage(), "Invalid Details", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }
}
