/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.cdilogin;

import be.kdg.model.LoginController;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author wouter
 */
@Named
@SessionScoped
public class LoginBean implements Serializable
{
    @Inject
    private LoginController loginController;
    
    private String email;
    private String password;
    
    /** Creates a new instance of LoginBean */
    public LoginBean()
    {
    }
    
    public String verifyUser()
    {
        if(loginController.checkLogin(email, password))
            return "welcome";
        else 
            return "failure";
    }
    
    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public void validateEmail(FacesContext facesContext, 
            UIComponent uIComponent, Object newValue) throws ValidatorException
    {
        String emailStr = newValue.toString();
        if(!emailStr.matches("[a-zA-Z0-9.]+@[a-zA-Z0-9.]+"))
            throw new ValidatorException(new FacesMessage("geen correct emailadres"));
    }
}
