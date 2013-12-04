/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.threads.example4;

import net.jcip.annotations.ThreadSafe;

/**
 *
 * @author deketelw
 */
@ThreadSafe
public class SharedClass
{
    private StringBuilder buffer = new StringBuilder();
    
    public void addText(String text)
    {
        synchronized(this)
        {
            buffer.append(text).append("\n");
        }
    }

    @Override
    public String toString()
    {
        return buffer.toString();
    }
    
    
}
