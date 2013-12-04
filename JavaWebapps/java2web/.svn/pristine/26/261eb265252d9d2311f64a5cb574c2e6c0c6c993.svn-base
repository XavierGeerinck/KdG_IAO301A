/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.threads.example3;

/**
 *
 * @author deketelw
 */
public class ProductPlacer implements Runnable
{

    private final ProductDatabase productenDB;

    public ProductPlacer(ProductDatabase productenDB)
    {
        this.productenDB = productenDB;
    }

    public void run()
    {
        for (int i = 0; i < 10; i++)
        {
            //System.out.println("Adding product " + i + " from " + Thread.currentThread().getName());
            this.productenDB.addProduct(new Product("P" + i, (double) i));
            Thread.yield();            
        }
    }
}
