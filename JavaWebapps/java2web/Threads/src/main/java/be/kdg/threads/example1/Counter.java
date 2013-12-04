/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.threads.example1;

/**
 *
 * @author deketelw
 */
public class Counter implements Counting
{
    private int value = 0;

    public int incrementAndGet()
    {
        return this.value++;
    }

    public int decrementAndGet()
    {
        return this.value--;
    }
}
