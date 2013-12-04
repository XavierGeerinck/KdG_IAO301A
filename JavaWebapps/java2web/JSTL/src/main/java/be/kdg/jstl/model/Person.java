/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.jstl.model;

/**
 *
 * @author wouter
 */
public class Person
{
    private String firstname;
    private String lastname;
    private Integer age;

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }
}
