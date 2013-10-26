package com.desple.services;

import com.desple.model.Ticket;
import com.desple.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Xavier
 * Date: 26/10/13
 * Time: 15:44
 * To change this template use File | Settings | File Templates.
 */
public class VerkoopService {
    public static boolean registerOrder(ArrayList<Ticket> tickets) {
        // Create session
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            // Start transaction
            transaction = session.beginTransaction();

            // Save all the tickets
            for (Ticket ticket : tickets) {
                session.save(ticket);
            }

            // Commit
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();

            // We had an error so return false
            return false;
        } finally {
            // Do not forget to close the session
            session.close();

            // Return true on success
            return true;
        }
    }
}
