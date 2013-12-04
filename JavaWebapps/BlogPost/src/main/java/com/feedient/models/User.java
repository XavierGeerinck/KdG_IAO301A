/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedient.models;

/**
 *
 * @author Thierry
 */
public class User {
    private String username;
    private String specialisatie;
    private String jaar;

    public User(String username, String specialisatie, String jaar) {
        this.username = username;
        this.specialisatie = specialisatie;
        this.jaar = jaar;
    }

    public User() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getUsername() {
        return username;
    }

    public String getSpecialisatie() {
        return specialisatie;
    }

    public String getJaar() {
        return jaar;
    }

    
    @Override
    public String toString() {
        return "User{" + "username=" + username + ", specialisatie=" + specialisatie + ", jaar=" + jaar + '}';
    }
    
    
    
    
}
