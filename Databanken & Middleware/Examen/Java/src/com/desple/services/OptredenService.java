package com.desple.services;

import com.desple.model.Optreden;
import com.desple.model.Zone;
import com.desple.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Xavier
 * Date: 26/10/13
 * Time: 15:44
 * To change this template use File | Settings | File Templates.
 */
public class OptredenService {
    public synchronized static List<Optreden> findOptredenByDateAndZone(Date date, Zone zone) {
        if (date == null || zone == null) {
            throw new NullPointerException("Date or zone can not be null.");
        }

        // Create session
        Session session = HibernateUtil.getSessionFactory().openSession();

        // Create a query
        Query query = session.createQuery("from Optreden o where o.startDate < :date and o.eindDate > :date and o.zone = :zone");

        // Bind parameters
        query.setParameter("date", date);
        query.setParameter("zone", zone);

        // Get result
        List<Optreden> results = query.list();

        // Close the session
        session.close();

        return results;
    }

    public synchronized static List<Optreden> findOptredenByDatesAndZone(Date dateIn, Date dateOut, Zone zone) {

        // Create session
        Session session = HibernateUtil.getSessionFactory().openSession();

        // Create a query
        Query query = session.createQuery("from Optreden o where o.zone = :zone and (o.startDate < :dateIn and :dateIn < o.eindDate) or " +
                "(o.startDate < :dateOut and :dateOut < o.eindDate  ) or" +
                "(:dateIn < o.startDate and o.eindDate < :dateOut) ");

        // Bind parameters
        query.setParameter("dateIn", dateIn);
        query.setParameter("dateOut", dateOut);
        query.setParameter("zone", zone);

        // Get result
        List<Optreden> results = query.list();

        // Close the session
        session.close();

        return results;
    }








}
