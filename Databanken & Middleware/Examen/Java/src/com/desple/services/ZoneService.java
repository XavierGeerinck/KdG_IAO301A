package com.desple.services;

import com.desple.model.Festival;
import com.desple.model.TicketType;
import com.desple.model.Zone;
import com.desple.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Xavier
 * Date: 26/10/13
 * Time: 21:01
 * To change this template use File | Settings | File Templates.
 */
public class ZoneService {
    public synchronized static List<Zone> getZonesByFestival(Festival f) {
        // Create session
        Session session = HibernateUtil.getSessionFactory().openSession();

        // Create a query
        Query query = session.createQuery("from Zone where festival = :festival");

        // Bind params
        query.setParameter("festival", f);

        // Get result
        List<Zone> results = query.list();

        // Close the session
        session.close();

        return results;
    }

    public synchronized static Zone getZoneById(Integer zoneId){
        if (zoneId == null){
            throw new NullPointerException("ZoneId is not set");
        }

        Session session = HibernateUtil.getSessionFactory().openSession();

        // Create a query
        Query query = session.createQuery("from Zone where id = :zoneId");

        // Bind params
        query.setParameter("zoneId", zoneId);

        // Get result
        Zone result = (Zone)query.uniqueResult();

        // Close the session
        session.close();

        return result;

    }
}
