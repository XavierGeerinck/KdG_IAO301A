/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.jsf.listeners;

import be.kdg.jsf.model.LoginControllerImpl;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author wouter
 */
public class SetModelListener implements ServletContextListener
{

    public void contextInitialized(ServletContextEvent sce)
    {
        sce.getServletContext().setAttribute("loginController", 
                new LoginControllerImpl());
    }

    public void contextDestroyed(ServletContextEvent sce)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
