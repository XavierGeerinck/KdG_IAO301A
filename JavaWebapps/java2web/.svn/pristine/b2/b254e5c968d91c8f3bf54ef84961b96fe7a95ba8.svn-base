/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.threads.example6;

/**
 *
 * @author wouter
 */
public class ThreadSafeBuffer implements Buffer
{
    private int value;
    private boolean occupied = false;

    public synchronized void setValue(int value)
    {
        while (occupied)
        {
            try
            {
                wait();
            }
            catch (InterruptedException ex)
            {
            }
        }
        this.value = value;
        System.out.println("Producer: geschreven " + value);        
        occupied = true; 
        notifyAll();
    }

    public synchronized int getValue()
    {
        while(!occupied)
        {
            try
            {
                wait();
            }
            catch (InterruptedException ex)
            {
               
            }
        }
        System.out.println("Consumer: gelezen " + value);
        occupied = false;
        notifyAll();
        return value;
    }
}
