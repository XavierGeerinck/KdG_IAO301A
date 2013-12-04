/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.threads.example5;

/**
 *
 * @author wouter
 */
public class UnSafeClient implements Runnable
{
    private LocalObject myLocalObject;
    public void run()
    {
        LocalObject localObject = new LocalObject();
        storeObject(localObject);
        
        for(int i = 0; i < 5; i++)
        {
            localObject.increaseCount();
            System.out.println(localObject + " met waarde van counter " + localObject.getCount());
        }
    }
    
    private void storeObject(LocalObject localObject)
    {
        this.myLocalObject = localObject;
    }

    public LocalObject getMyLocalObject()
    {
        return myLocalObject;
    }
}

