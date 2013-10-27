package com.desple.main;

import com.desple.gui.CreateTicketView;
import com.desple.gui.MainView;
import com.desple.model.Festival;
import com.desple.model.Zone;
import com.desple.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Xavier
 * Date: 26/10/13
 * Time: 15:18
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
        // Start gui in a thread.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainView view = new MainView();
                view.setVisible(true);
            }
        });
    }
}
