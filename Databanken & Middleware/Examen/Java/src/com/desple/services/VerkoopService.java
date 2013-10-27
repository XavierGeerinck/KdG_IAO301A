package com.desple.services;

import com.desple.model.Koper;
import com.desple.model.Ticket;
import com.desple.model.TicketOrder;
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
    public synchronized static void registerOrder(Koper koper, TicketOrder ticketOrder, ArrayList<Ticket> tickets) {
        // Validation
        if (tickets == null || tickets.isEmpty()) {
            throw new NullPointerException("Tickets is not set");
        }

        // Create session
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            // Start transaction
            transaction = session.beginTransaction();

            System.out.println("Saving tickets to db");

            // Save the koper
            session.save(koper);

            // Save the ticket order
            session.save(ticketOrder);

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
            throw e;
        } finally {
            // Do not forget to close the session
            session.close();
        }
    }
}
