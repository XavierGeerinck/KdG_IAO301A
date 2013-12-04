/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.threads.example6;

/**
 *
 * @author wouter
 */
public class Producer implements Runnable
{
    private final Buffer buffer;

    public Producer(Buffer buffer)
    {
        this.buffer = buffer;
    }

    public void run()
    {
        for (int i = 0; i < 10; i++)
            buffer.setValue(i);
    }
}
