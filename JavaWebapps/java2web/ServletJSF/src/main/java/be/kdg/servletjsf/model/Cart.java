/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.servletjsf.model;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author wouter
 */
public class Cart
{
    private List<String> items;

    public Cart()
    {
        this.items = Arrays.asList("bananen","appelen","peren");
    }

    public List<String> getItems()
    {
        return items;
    }
    
}
