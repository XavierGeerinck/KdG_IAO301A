/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.threads.example4;

/**
 *
 * @author deketelw
 */
public class AdderThread implements Runnable
{

    private SharedClass buffer;
    private final String text;

    public AdderThread(SharedClass buffer, String text)
    {
        this.buffer = buffer;
        this.text = text;
    }
    
    public void run()
    {
        while(!Thread.interrupted())
        {
            this.buffer.addText(text);
            try
            {
                Thread.sleep(100);
            } catch (InterruptedException ex)
            {
               break;
            }
        }
    }
    
    
}
