package be.kdg.webapps102.events;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletContextMonitor implements ServletContextListener, ServletContextAttributeListener
{
    @Override
    public void contextInitialized(ServletContextEvent event)
    {
        System.out.println("de servlet context is opgestart");
    }

    @Override
    public void contextDestroyed(ServletContextEvent event)
    {
        System.out.println("de servlet context wordt verwijderd");
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent event)
    {
        String name = event.getName();
        Object value = event.getValue();
        System.out.println("attribuut " + name + " werd op volgende waarde gezet: " + value);
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event)
    {
        String name = event.getName();
        System.out.println("attribuut " + name + " werd verwijderd");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event)
    {
        String name = event.getName();
        Object value = event.getValue();
        System.out.println("attribuut " + name + " werd op veranderd in: " + value);
    }
}
