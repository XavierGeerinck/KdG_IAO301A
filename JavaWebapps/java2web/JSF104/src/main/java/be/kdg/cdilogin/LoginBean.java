/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.cdilogin;

import be.kdg.model.LoginController;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
    
    @NotNull
    @Pattern(regexp="[a-zA-Z0-9.]+@[a-zA-Z0-9.]+", message="Gelieve een geldig email adres te geven")
    private String email;
    
    @NotNull
    @Size(min=3, message="Password moet minstens 3 karakters bevatten")
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
}
