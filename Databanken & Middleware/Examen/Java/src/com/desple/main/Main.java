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

        try {
            transaction = session.beginTransaction();

            Festival festival = new Festival();
            festival.setEindDate(new Date());
            festival.setStartDate(new Date());
            festival.setLocatie("Somewhere in nowhere");

            session.save(festival);

            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
