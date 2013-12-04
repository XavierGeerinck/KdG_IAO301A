/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.threads.example1;

/**
 *
 * @author deketelw
 */
public class SafeCounter implements Counting
{
    private int count;
    
    public synchronized int incrementAndGet()
    {
        return count++;
    }
    
    public synchronized int decrementAndGet()
    {
        return count--;
    }
}
