/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.shop.persistence.factory;

import be.kdg.shop.persistence.dao.interfaces.StockDAO;
import be.kdg.shop.persistence.dao.interfaces.UserDAO;

/**
 *
 * @author wouter
 */
public abstract class DAOFactory
{
    public static Class MapDAOFActory = MapDAOFActory.class;
    
    public static DAOFactory instance(Class factory)
    {
        try
        {
            return (DAOFactory) factory.newInstance();
        } catch (Exception ex)
        {
            throw new RuntimeException("Couldn't create DAOFactory: " + factory);
        }
    }

    public abstract UserDAO getUserDAO();
    public abstract StockDAO getStockDAO();
}
