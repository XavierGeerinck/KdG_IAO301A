/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.jstl.model;

/**
 *
 * @author wouter
 */
public class User
{
    private String username;
    private String password;
    private Person person;

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public Person getPerson()
    {
        return person;
    }

    public void setPerson(Person person)
    {
        this.person = person;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    @Override
    public String toString()
    {
        return "User{" + "username=" + username + ", password=" + password + '}';
    }
}
