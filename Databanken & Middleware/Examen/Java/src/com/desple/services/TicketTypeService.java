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
 * Time: 20:56
 * To change this template use File | Settings | File Templates.
 */
public class TicketTypeService {
    public synchronized static List<TicketType> getTicketTypes(Festival f) {
        // Create session
        Session session = HibernateUtil.getSessionFactory().openSession();

        // Create a query
        Query query = session.createQuery("from TicketType where festival = :festival");

        // Bind params
        query.setParameter("festival", f);

        // Get result
        List<TicketType> results = query.list();

        // Close session
        session.close();

        return results;
    }
}
