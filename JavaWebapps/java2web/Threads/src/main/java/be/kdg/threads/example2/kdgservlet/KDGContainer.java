/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.threads.example2.kdgservlet;

import be.kdg.threads.example2.kdgservlet.servlets.AnotherServlet;
import be.kdg.threads.example2.kdgservlet.servlets.MyServlet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author deketelw
 */
public class KDGContainer
{
    private List<KDGServlet> servlets;
    private final ExecutorService threadPool;

    public KDGContainer()
    {
        this.servlets = new ArrayList<KDGServlet>();        
        this.threadPool = Executors.newCachedThreadPool();
    }

    private void startUp()
    {
        // welke servlets er zijn wordt door normaal door
        // configuratie(annotaties of xml-bestanden) bepaald
        this.servlets.add(new MyServlet());
        this.servlets.add(new AnotherServlet());
    }
    
    private void shutDown()
    {
        threadPool.shutdown();
    }

    public void simulateRequest(final int index)
    {
        threadPool.execute(
                new Runnable()
                {
                    public void run()
                    {
                        servlets.get(index).doGet(new KDGHttpRequest(), new KDGHttpResponse());
                    }
                });
    }

    public static void main(String[] args)
    {
        KDGContainer container = new KDGContainer();
        container.startUp();
        container.simulateRequest(0);
        container.simulateRequest(0);
        container.simulateRequest(1);
        container.simulateRequest(1);
        container.simulateRequest(0);
        container.shutDown();
    }
}
