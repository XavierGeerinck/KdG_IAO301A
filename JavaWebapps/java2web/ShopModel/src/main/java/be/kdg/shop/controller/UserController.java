package be.kdg.shop.controller;

import be.kdg.shop.model.shopping.Order;
import be.kdg.shop.model.stock.Product;
import be.kdg.shop.model.user.*;
import be.kdg.shop.model.user.exceptions.LoginException;
import be.kdg.shop.persistence.dao.interfaces.UserDAO;
import be.kdg.shop.persistence.factory.DAOFactory;
import java.util.*;

public class UserController
{
    private final UserDAO userDAO;

    public UserController()
    {
        userDAO = DAOFactory.instance(DAOFactory.MapDAOFActory).getUserDAO();
    }

    /**
     * Hier wordt gecontroleerd of de user bestaat en of zijn password
     * correct is.  Indien één van deze controles faalt, 
     * wordt een LoginException gegooid.
     * @param username gebruikersnaam
     * @param password wachtwoord
     * @throws LoginException indien fout credentials gegeven zijn
     */
    public void checkLogin(String username, String password) throws LoginException
    {
        // haal deze gebruiker op
        User user;
        try
        {
            user = userDAO.getUser(username);            
            // mogelijk is user null -> NullPointerException 
            if (!user.checkPassword(password.toCharArray()))
            {
                throw new LoginException(("Gebruikersnaam of password foutief"));
            }            
        }
        catch(Exception ex)
        {
            throw new LoginException(("Gebruikersnaam of password foutief"));
        }
        
    }

    /**
     * Voeg een gebruiker toe aan het systeem.
     * @param user 
     */
    public void addUser(User user)
    {
        userDAO.addUser(user);
    }
    
    /**
     * Verwijdert een gebruiker op basis van de gebruikersnaam
     * @param user 
     */
    public void removeUser(String username)
    {
        userDAO.removeUser(username);
    }

    /**
     * Pas voor dit product de winkelkarhoeveelheid aan.
     * Dit getal kan ook negatief zijn. 
     * De juiste hoeveelheid moet berekend worden.
     * @param user
     * @param product
     * @param amount 
     */
    public void updateCart(User user, Product product, int amount)
    {
        user.getCart().updateProduct(product, amount);
    }

    /**
     * Maakt een bestelling op basis van de huidige winkelkarinhoud
     * @param user
     * @return 
     */
    public Order checkOut(User user)
    {
        return user.createOrder();
    }

    /**
     * Haalt voor deze gebruiker de aanwezige hoeveelheid product op 
     * uit zijn huidige winkelkarretje.  Wordt gebruikt om de hoeveelheden 
     * te berekenen die aangepast zullen moeten worden.
     * @param user
     * @param product
     * @return 
     */
    public Integer getCartItemAmount(User user, Product product)
    {
        return user.getCart().getCartItemAmount(product);
    }

    /**
     * Geef de gebruiker die hoort bij deze username
     * @param username
     * @return 
     */
    public User getUser(String username) throws LoginException
    {
        try
        {
            return userDAO.getUser(username);
        } catch (ConcurrentModificationException ex)
        {
            throw new LoginException(ex.getMessage());
        }
    }

    /**
     * Geef alle gebruikers met gebruikersnaam die het systeem kent
     * @return 
     */
    public Map<String, User> getUsers()
    {
        return userDAO.getUsers();
    }
}