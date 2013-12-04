/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.valueevents;

import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author wouter
 */
@ManagedBean(name="form")
@SessionScoped
public class RegisterForm
{
    private String streetAddress;
    private String city;
    private String state;
    private String country;
    
    private static final Locale[] countries =
    {
        Locale.US, Locale.CANADA
    };

    /**
     * Creates a new instance of RegisterForm
     */
    public RegisterForm()
    {
    }

    public Locale[] getCountries()
    {
        return countries;
    }

    public void countryChanged(ValueChangeEvent event)
    {
        for (Locale loc : countries)
        {
            if (loc.getCountry().equals(event.getNewValue()))
            {
                FacesContext.getCurrentInstance().getViewRoot().setLocale(loc);
            }
        }
        FacesContext.getCurrentInstance().renderResponse();
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getStreetAddress()
    {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress)
    {
        this.streetAddress = streetAddress;
    }
    
}
