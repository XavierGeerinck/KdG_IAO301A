/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.blogpost.models;

/**
 *
 * @author Thierry
 */
public class Post {
    private int id;
    private String jaar;
    private User user;
    private String specialisatie;
    private String omschrijving;
    private String url;

    public Post(int id, User user, String omschrijving, String url) {
        this.id = id;
        this.jaar = user.getJaar();
        this.user = user;
        this.omschrijving = omschrijving;
        this.specialisatie = user.getSpecialisatie();
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public String getJaar() {
        return jaar;
    }

    public User getUser() {
        return user;
    }

    public String getSpecialisatie() {
        return specialisatie;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Post{" + "id=" + id + ", jaar=" + jaar + ", user=" + user + ", specialisatie=" + specialisatie + ", omschrijving=" + omschrijving + ", url=" + url + '}';
    }
    
    
    
    
}


