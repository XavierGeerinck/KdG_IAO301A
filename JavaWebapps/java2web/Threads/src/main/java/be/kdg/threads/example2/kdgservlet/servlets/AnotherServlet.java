/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.threads.example2.kdgservlet.servlets;

import be.kdg.threads.example2.kdgservlet.KDGHttpRequest;
import be.kdg.threads.example2.kdgservlet.KDGHttpResponse;
import be.kdg.threads.example2.kdgservlet.KDGServlet;

/**
 *
 * @author wouter
 */
public class AnotherServlet extends KDGServlet
{

    @Override
    public void doGet(KDGHttpRequest request, KDGHttpResponse response)
    {
        System.out.println(this.toString().replace("be.kdg.threads.example2.kdgservlet.servlets.", "") + " : AnotherServlet doet vanalles hier");
    }
    
}
