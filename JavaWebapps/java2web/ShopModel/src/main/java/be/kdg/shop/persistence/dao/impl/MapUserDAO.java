/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.shop.persistence.dao.impl;

import be.kdg.shop.model.user.User;
import be.kdg.shop.persistence.dao.interfaces.UserDAO;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author wouter
 */
public class MapUserDAO implements UserDAO
{
    private final ConcurrentHashMap<String, User> users;
    
    public MapUserDAO()
    {
        this.users = new ConcurrentHashMap<String, User>();
    }

    /**
     * Geef de User horende bij deze gebruikersnaam
     * @param username
     * @return 
     */
    public User getUser(String username)
    {
        return users.get(username);
    }

    /**
     * Voeg een gebruiker toe aan 
     * @param user 
     */
    public void addUser(User user)
    {
        users.put(user.getUsername(), user);
    }
    
    /**
     * Verwijder een gebruiker met deze gebruikersnaam
     * @param username 
     */
    public void removeUser(String username)
    {
        if(users.containsKey(username))
            users.remove(username);
    }

    /**
     * Geef een lijst van alle gekende gebruikers
     * @return 
     */
    public Map<String, User> getUsers()
    {
        return users;
    }    
}
