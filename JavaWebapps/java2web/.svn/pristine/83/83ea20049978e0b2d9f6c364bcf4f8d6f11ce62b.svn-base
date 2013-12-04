/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.threads.example3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author deketelw
 */

public class ProductDatabase
{
    private final List<Product> producten = new ArrayList<Product>();
    
    //ThreadSafe
    //public synchronized void addProduct(Product p)
    
    //Not ThreadSafe
    public void addProduct(Product p)
    {
        producten.add(p);
    }
    
    public synchronized boolean containsProduct(Product p)
    {
        return producten.contains(p);
    }
    
    public synchronized int getSize()
    {
        return producten.size();
    }
    
    @Override
    public String toString()
    {
        return producten.toString();
    }
    
}
