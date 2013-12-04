/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.servletjsf.model;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author wouter
 */
@Named
@ApplicationScoped
public class CartController implements Serializable
{
    private Map<String,Cart> carts;

    public CartController()
    {
        this.carts = new ConcurrentHashMap<String, Cart>();
        this.carts.put("Wouter", new Cart());
    }
    
    public Cart getCart(String name)
    {
        return carts.get(name);
    }
    
}
