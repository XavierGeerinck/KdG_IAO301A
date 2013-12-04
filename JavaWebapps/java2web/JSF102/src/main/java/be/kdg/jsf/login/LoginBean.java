/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.jsf.login;

import be.kdg.model.LoginController;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author wouter
 */

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean
{
    @ManagedProperty(value="#{loginController}")
    private LoginController loginController;
    private String email;
    private String password;
    
    /** Creates a new instance of LoginBean */
    public LoginBean()
    {
    }
    
    public String checkCredentials()
    {
        if(loginController.checkLogin(email, password))
            return "succes";
        else 
            return "failure";
    }
    
    public void validateEmail(FacesContext facesContext, UIComponent uIComponent, Object newValue) throws ValidatorException
    {
        String emailStr = newValue.toString();
        if(!emailStr.matches("[a-zA-Z0-9.]+@[a-zA-Z0-9.]+"))
            throw new ValidatorException(new FacesMessage("geen correct emailadres"));
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
    
    public LoginController getLoginController()
    {
        return loginController;
    }

    public void setLoginController(LoginController loginController)
    {
        this.loginController = loginController;
    }
    
}
