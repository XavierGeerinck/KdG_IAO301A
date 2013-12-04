/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.threads.example6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author wouter
 */
public class ConsumerProducerTest
{
    public static void main(String[] args)
    {
        final ExecutorService threadPool = Executors.newCachedThreadPool();
        final Buffer buffer = new ThreadSafeBuffer();
        threadPool.execute(new Consumer(buffer));
        threadPool.execute(new Producer(buffer));
        threadPool.shutdown();
    }
    
}
