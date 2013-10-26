package com.desple.services;

import com.desple.model.Festival;
import com.desple.model.FestivalDag;
import com.desple.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Xavier
 * Date: 26/10/13
 * Time: 20:38
 * To change this template use File | Settings | File Templates.
 */
public class FestivalDagService {
    public static List<FestivalDag> getFestivalDagen(Festival f) {
        // Create session
        Session session = HibernateUtil.getSessionFactory().openSession();

        // Create a query
        Query query = session.createQuery("from FestivalDag where festival = :festival");

        // Bind parameters
        query.setParameter("festival", f);

        // Get result
        List<FestivalDag> results = query.list();

        return results;
    }
}
