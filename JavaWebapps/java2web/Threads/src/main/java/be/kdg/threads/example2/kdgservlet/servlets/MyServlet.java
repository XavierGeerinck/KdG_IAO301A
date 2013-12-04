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
 * @author deketelw
 */
public class MyServlet extends KDGServlet
{
    @Override
    public void doGet(KDGHttpRequest request, KDGHttpResponse response)
    {
        // Wie refereert er allemaal naar request en/of response
        System.out.println(this.toString().replace("be.kdg.threads.example2.kdgservlet.servlets.", "") + " : " 
                + Thread.currentThread().getName() + " - " 
                + request.toString().replace("be.kdg.threads.example2.kdgservlet.","") + " - " 
                + response.toString().replace("be.kdg.threads.example2.kdgservlet.",""));
    }
    
}
