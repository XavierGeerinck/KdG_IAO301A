package be.kdg.jsf2ajax;

import java.io.Serializable;
import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedBean;
// or import javax.inject.Named;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
// or import javax.enterprise.context.SessionScoped;

@ManagedBean(name = "user") // or @Named("user")
@SessionScoped
public class UserBean implements Serializable
{
    private String name = "";
    private String password;

    public String getName()
    {
        return name;
    }

    public void setName(String newValue)
    {
        name = newValue;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String newValue)
    {
        password = newValue;
    }

    public void validateName(FacesContext fc, UIComponent c, Object value)
    {
        if (((String) value).contains("_"))
        {
            throw new ValidatorException(
                    new FacesMessage("Name cannot contain underscores"));
        }
    }

    public void processAjaxBehavior(javax.faces.event.AjaxBehaviorEvent event) throws javax.faces.event.AbortProcessingException
    {
        System.out.println("I have been called by an Ajax request");
    }
}
