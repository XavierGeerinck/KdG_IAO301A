/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.blogpost.listeners;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author Thierry
 */
public class MySessionListener implements HttpSessionListener, HttpSessionAttributeListener
{

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("New session created: " + se.getSession().toString());
   }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Session destroyed");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("Session attribute created: " + event.getName());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("Session attribute removed");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("Session attribute replaced: " + event.getName());
    }
    
}
