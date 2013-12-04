/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.threads.example5;

/**
 *
 * @author wouter
 */
public class SafeClient implements Runnable
{
    public void run()
    {
        LocalObject localObject = new LocalObject();
        for(int i = 0; i < 5; i++)
        {
            localObject.increaseCount();
            System.out.println(localObject + " met waarde van counter " + localObject.getCount());
        }
    }
}
