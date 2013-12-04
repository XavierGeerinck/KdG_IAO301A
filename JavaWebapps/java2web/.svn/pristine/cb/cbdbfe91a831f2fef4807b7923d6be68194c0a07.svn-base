/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.threads.example1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author deketelw
 */
public class CounterClient implements Runnable
{
    // Dit instance field bevat de shared data    
    private Counting counter;

    public CounterClient(Counting counter)
    {
        this.counter = counter;
    }

    public void run()
    {
        while(true)
        {
            System.out.println("Incrementing from " + Thread.currentThread().getName() );                
            System.out.println("Counter value in " + Thread.currentThread().getName() + " = " + counter.incrementAndGet());                
            
            try
            {
                Thread.sleep(2000L);
            } catch (InterruptedException ex)
            {
                Logger.getLogger(CounterClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
