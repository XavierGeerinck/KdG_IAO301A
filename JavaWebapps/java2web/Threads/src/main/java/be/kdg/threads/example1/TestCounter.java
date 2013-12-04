/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.threads.example1;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 *
 * @author deketelw
 */
public class TestCounter
{
    public static void main(String args[])
    {
        Counter counter = new Counter();
        SafeCounter safeCounter = new SafeCounter();
        
        Executor exec = Executors.newCachedThreadPool();
        
        exec.execute(new CounterClient(counter));
        exec.execute(new CounterClient(counter));        
        /*
        exec.execute(new CounterClient(safeCounter));
        exec.execute(new CounterClient(safeCounter));
         */
         
    }
    
}
