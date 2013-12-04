/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.threads.example5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author wouter
 */
public class TestLocalObject
{
    public static void main(String[] args) throws InterruptedException
    {
        final ExecutorService threadPool = Executors.newCachedThreadPool();
        
        // Mega veilig
        threadPool.execute(new SafeClient());
        threadPool.execute(new SafeClient());        
        
        // Dit is dus not thread safe
        // want je houdt hier een referentie bij naar een UnSafeClient;
        UnSafeClient unSafeClient = new UnSafeClient();
        threadPool.execute(unSafeClient);        
        
        // AnotherClient gebruikt nietsvermoedend een Not Thread Safe object !!
        AnotherClient anotherClient = new AnotherClient(unSafeClient.getMyLocalObject());
        
        threadPool.execute(anotherClient);        
        
        // Toch nog steeds veilig want je houdt geen referentie bij naar 
        // de unsafe client
        threadPool.execute(new UnSafeClient());        
        threadPool.shutdown();
        
        while(!threadPool.isTerminated())
        {
            Thread.sleep(100);
        }
                
        unSafeClient.getMyLocalObject().increaseCount();
        System.out.println("In main Thread " + unSafeClient.getMyLocalObject() + " met waarde van counter " + unSafeClient.getMyLocalObject().getCount());
        
    }
}
