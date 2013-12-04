/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.servletjsf.model;

/**
 *
 * @author wouter
 */
public class User
{
    private String name;
    private String password;

    public User(String naam, String wachtwoord)
    {
        this.name = naam;
        this.password = wachtwoord;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
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
