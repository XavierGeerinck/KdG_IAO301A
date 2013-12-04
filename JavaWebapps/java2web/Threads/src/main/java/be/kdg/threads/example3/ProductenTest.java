/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.threads.example3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author deketelw
 */
public class ProductenTest
{

    public static void main(String args[]) throws InterruptedException
    {
        ExecutorService exec = Executors.newCachedThreadPool();

        // productenDB is een shared object
        ProductDatabase productenDB = new ProductDatabase();

        for (int i = 0; i < 10; i++)
        {
            ProductPlacer pl1 = new ProductPlacer(productenDB);
            exec.execute(pl1);
        }
        
        exec.shutdown();
        exec.awaitTermination(1000, TimeUnit.SECONDS);

        System.out.println("Producten " + productenDB);
        System.out.println("Aantal producten " + productenDB.getSize());
    }
}
