/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.spring103.controller.form;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.springframework.stereotype.Component;

/**
 *
 * @author wouter
 */
@Component
public class LoginFormBean implements Serializable
{
    @NotNull(message="username mag niet leeg zijn")
    @Pattern(regexp="[a-zA-Z0-9.]+@[a-zA-Z0-9.]+", message="Gelieve een geldig email adres te geven")
    private String username = "Geef uw naam";
    @NotNull(message="password mag niet leeg zijn")
    @Size(min = 3, max = 30, message="password moet minstens 3 karakters en maximaal 30 karaketers lang zijn")
    private String password = "Geef uw password";

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
