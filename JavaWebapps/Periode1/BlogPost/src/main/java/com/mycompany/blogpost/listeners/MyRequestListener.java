/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.blogpost.listeners;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 *
 * @author Thierry
 */
public class MyRequestListener implements ServletRequestAttributeListener, ServletRequestListener {

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println("Request attribute added: "+ srae.getName());
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        System.out.println("Request attribute removed: " + srae.getName());
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        System.out.println("Request attribute replaced: " + srae.getName());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("Request created");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("Request deleted");
    }
    
}
