package com.desple.services;

import com.desple.model.Artiest;
import com.desple.model.Festival;
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
public class FestivalService {
    public static List<Festival> findFestivalByArtistAndDate(Artiest artiest, Date dateStart, Date dateEnd) {
        if (artiest == null || dateStart == null || dateEnd == null) {
            throw new NullPointerException("Date or artiest can not be null.");
        }

        // Create session
        Session session = HibernateUtil.getSessionFactory().openSession();

        // Create a query
        // Problem here, need to be denormalized in the db since else this query will degrade performance by a factor of x3
        // IDea is to give artist an Optreden, this will be: Artiest can have multiple optredens but optreden has 1 artiest
        //Query query = session.createQuery("from Optreden where  = :artiest");

        // Bind parameters
        //query.setParameter("date", date);
        //query.setParameter("zone", zone);

        // Get result
        //List<Optreden> results = query.list();

        //return results;
        return null;
    }

    public static List<Festival> getFestivals() {
        // Create session
        Session session = HibernateUtil.getSessionFactory().openSession();

        // Create a query
        Query query = session.createQuery("from Festival");

        // Get result
        List<Festival> results = query.list();

        return results;
    }
}
