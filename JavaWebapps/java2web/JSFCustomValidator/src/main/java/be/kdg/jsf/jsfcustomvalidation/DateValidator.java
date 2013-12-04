/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.jsf.jsfcustomvalidation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Wouter
 */
@FacesValidator("dateValidator")
public class DateValidator implements Validator
{
    private String expression = "^[0-1][1-9][- / ]?(0[1-9]|[12][0-9]|3[01])[- /]?(18|19|20|21)\\d{2}$"; 

    @Override
    public void validate(FacesContext context, UIComponent c, Object val) throws ValidatorException
    {
        Date date = (Date) val;
        Pattern mask = Pattern.compile(expression);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Matcher matcher = mask.matcher(formatter.format(date));

        if (!matcher.matches())
        {
            FacesMessage message = new FacesMessage();
            message.setDetail("Please enter a valid date");
            message.setSummary("Date is not valid");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
    }
}

