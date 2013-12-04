/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.servletjsf.beans;

import be.kdg.servletjsf.model.Cart;
import be.kdg.servletjsf.model.CartController;
import be.kdg.servletjsf.model.User;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author wouter
 */
@Named
@SessionScoped
public class ShopBean implements Serializable
{
    private String name;
        
    @Inject
    private CartController cartController;    
    
    public String getName()
    {
        return name;
    }
    
    public Cart getCart()
    {
        final HttpServletRequest request =  (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        User user = (User) request.getSession().getAttribute("user");
        this.name = user.getName();
        return cartController.getCart(name);
    }
}
