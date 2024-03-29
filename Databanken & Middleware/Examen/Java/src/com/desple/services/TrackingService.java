package com.desple.services;

import com.desple.model.Tracking;
import com.desple.model.Zone;
import com.desple.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Xavier
 * Date: 26/10/13
 * Time: 15:45
 * To change this template use File | Settings | File Templates.
 */
public class TrackingService {
    public synchronized static void savePassage(Tracking tracking) {
        // Validation
        if (tracking == null) {
            throw new NullPointerException("Bezoeker or zone are null.");
        }

        // Saving to the database

        // Create session
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            // Create a transaction
            transaction = session.beginTransaction();

            // Persist the objects
            session.save(tracking);

            // When persisting succeeded and no errors found then commit.
            transaction.commit();
        } catch (HibernateException e) {
            // Catch the error and rollback if we found one
            transaction.rollback();

            // Show a beautifull stacktrace :3
            e.printStackTrace();
        } finally {
            // If everything is done close the session
            session.close();
        }
    }
}
