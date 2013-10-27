package com.desple.services;

import com.desple.model.Artiest;
import com.desple.model.FestivalDag;
import com.desple.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Xavier
 * Date: 27/10/13
 * Time: 20:48
 * To change this template use File | Settings | File Templates.
 */
public class ArtiestService {
    public static List<Artiest> getArtists() {
        // Create session
        Session session = HibernateUtil.getSessionFactory().openSession();

        // Create a query
        Query query = session.createQuery("from Artiest");

        // Get result
        List<Artiest> results = query.list();

        // Close session
        session.close();

        return results;
    }
}
