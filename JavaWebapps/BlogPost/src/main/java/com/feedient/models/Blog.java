/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedient.models;

import java.util.HashMap;

/**
 *
 * @author Thierry
 */
public class Blog {
    private String name;
    private int counter;
    private HashMap<Integer, Post> map = new HashMap<Integer, Post>();

    public Blog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
   
    public int addBlogPost(User user, String omschrijving, String url  ){
        synchronized(this){
            this.counter++;
            Post post = new Post(this.counter, user, omschrijving, url);
            this.map.put(this.counter, post);
        }

        return this.counter;
    }
    
    public int addBlogPost(String username, String specialisatie, String jaar, String omschrijving, String url  ){
        synchronized(this){
            this.counter++;
            User user = new User(username, specialisatie, jaar);
            Post post = new Post(this.counter, user, omschrijving, url);
            this.map.put(this.counter, post);
        }
        return this.counter;
        
    }

    public HashMap<Integer, Post> getMap() {
        return map;
    }
}
