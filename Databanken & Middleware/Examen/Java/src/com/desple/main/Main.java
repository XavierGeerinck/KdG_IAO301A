package com.desple.main;

import com.desple.model.Festival;
import com.desple.model.Zone;
import com.desple.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        // Create a festival
        Festival festival = new Festival();
        festival.setEindDate(new Date());
        festival.setStartDate(new Date());
        festival.setLocatie("Somewhere in nowhere");

        // Saving to the database
        try {
            // Create a transaction
            transaction = session.beginTransaction();

            // Persist the objects
            session.save(festival);

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
