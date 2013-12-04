/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.threads.example4;

/**
 *
 * @author deketelw
 */
public class AdderTester
{
    public static void main(String args[])
    {
        SharedClass buffer = new SharedClass();
        Thread t1 = new Thread(new AdderThread(buffer, "Tekst van t1 "));
        Thread t2 = new Thread(new AdderThread(buffer, "Tekst van t2 "));
        
        t1.start();
        t2.start();
        try
        {
            Thread.sleep(1000);
        } catch (InterruptedException ex)
        {
            t1.interrupt();
            t2.interrupt();
        }
        System.out.println(buffer);
        System.exit(0);
    }
    
    
}
