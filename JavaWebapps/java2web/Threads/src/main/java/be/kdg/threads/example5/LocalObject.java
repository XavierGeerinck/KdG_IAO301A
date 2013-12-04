/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.threads.example5;

/**
 *
 * @author wouter
 */
public class LocalObject
{
    private int count = 0;
    
    public void increaseCount()
    {
        count++;
    }

    public int getCount()
    {
        return count;
    }
}
