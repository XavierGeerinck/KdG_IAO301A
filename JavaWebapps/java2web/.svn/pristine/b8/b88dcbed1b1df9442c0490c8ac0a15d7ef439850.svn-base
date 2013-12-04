/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.threads.example6;

/**
 *
 * @author wouter
 */
public class Consumer implements Runnable
{
    private final Buffer buffer;

    public Consumer(Buffer buffer)
    {
        this.buffer = buffer;
    }
        
    public void run()
    {
        for(int i = 0; i < 10; i++)
            buffer.getValue();
    }    
}
