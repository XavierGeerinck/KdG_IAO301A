/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.blogpost.listeners;

import com.mycompany.blogpost.models.Blog;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author Thierry
 */
public class MyContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Start of Program");
        Blog blog = new Blog("Thierry's Blog");
        ServletContext sc = sce.getServletContext();
        sc.setAttribute("blog", blog);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("End of program");
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
