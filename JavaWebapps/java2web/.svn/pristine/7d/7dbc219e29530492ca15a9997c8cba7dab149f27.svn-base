/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.jsf.jsfcustomvalidation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Wouter
 */
@ManagedBean
@SessionScoped
public class DateBean
{
    private Date gekozen;    
    private Date datum;
    private Date minDate;
    private Date maxDate;    
    private List<Date> dates;    
    
    public DateBean()
    {
        Random random = new Random();
        dates = new ArrayList<Date>();
        for(int i = 0; i < 10; i++)
        {
            dates.add(new Date());
            dates.get(i).setDate(i);
        }        
        this.minDate = dates.get(0);
        this.maxDate = dates.get(dates.size()-1);        
        this.gekozen = dates.get(random.nextInt(dates.size() - 1));
        System.out.println(gekozen);
    }

    public Date getDatum()
    {
        return datum;
    }

    public void setDatum(Date datum)
    {
        this.datum = datum;
    }

    public Date getMaxDate()
    {
        return maxDate;
    }

    public void setMaxDate(Date maxDate)
    {
        this.maxDate = maxDate;
    }

    public Date getMinDate()
    {
        return minDate;
    }

    public void setMinDate(Date minDate)
    {
        this.minDate = minDate;
    }

    public List<Date> getDates()
    {
        return dates;
    }

    public void setDates(List<Date> dates)
    {
        this.dates = dates;
    }

    public String guess()
    {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Date date = (Date) facesContext.getExternalContext().getRequestMap().get("date");        
        if(date != null)
            if(gekozen.getDay() == date.getDay() && gekozen.getMonth() == date.getMonth() && gekozen.getYear() ==  date.getYear())                
                return "succes";
            else
                dates.remove(date);
        else
            if(gekozen.getDay() == datum.getDay() && gekozen.getMonth() == datum.getMonth() && gekozen.getYear() ==  datum.getYear())                
                return "succes";
                
        return "failure";
    }    
}
