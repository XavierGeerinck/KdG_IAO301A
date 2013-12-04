package be.kdg.shop.facade;

import be.kdg.shop.controller.*;
import be.kdg.shop.model.shopping.Order;
import be.kdg.shop.model.stock.Product;
import be.kdg.shop.model.stock.exceptions.StockException;
import be.kdg.shop.model.user.Address;
import be.kdg.shop.model.user.Person;
import be.kdg.shop.model.user.Role;
import be.kdg.shop.model.user.User;
import be.kdg.shop.model.user.exceptions.LoginException;
import java.util.Collection;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Store
{
    private final StockController stockController;
    private final UserController userController;
    private final String name;

    public Store()
    {
        stockController = new StockController();
        userController = new UserController();
        name = "KDG Webshop";
        initStore();
    }

    /**
     * Checkt de logingegevens van de gebruiker.
     *
     * @param username uniek emailadres
     * @param password wachtwoord
     */
    public void checkLogin(String username, String password) throws LoginException
    {
        userController.checkLogin(username, password);
    }

    /**
     * Voeg een gebruiker toe
     *
     * @param user
     */
    public void addUser(User user)
    {
        userController.addUser(user);
    }

    /**
     * Wijzig de gebruiker met een bepaalde gebruikersnaam
     *
     * @param user
     * @param person
     * @param password
     * @param role
     */
    public void updateUser(User user, Person person, Role role)
    { 
        user.setPerson(person);
        user.setRole(role);
    }

    /**
     * Wijzig het password voor een bepaalde gebruiker
     *
     * @param user
     * @param person
     * @param password
     * @param role
     */
    public void updatePassword(User user, String oldPassword, String newPassword) throws LoginException
    {
        user.changePassword(oldPassword,newPassword);
    }

    /**
     * Verwijder een gebruiker
     *
     * @param username
     */
    public void removeUser(User user)
    {
        userController.removeUser(user.getUsername());
    }

    /**
     * Vraag de producten op horende bij deze categorie
     *
     * @param categorie
     * @return
     */
    public Collection<Product> getProductsOfCategory(String categorie)
    {
        return this.stockController.getProductsOfCategory(categorie);
    }

    /**
     * Vraag het product op dat hoort bij deze beschrijving
     *
     * @param description
     * @return
     */
    public Product getProductByDescription(String productName)
    {
        return this.stockController.getProductByDescription(productName);
    }

    /**
     * Geef alle aanwezige categorieën van producten in de database
     *
     * @return
     */
    public Collection<String> getCategories()
    {
        return this.stockController.getCategories();
    }

    /**
     * Pas het winkelkarretje aan voor de gebruiker. Men kan hiermee producten
     * toevoegen of verwijderen. Deze functie past ook de stock automatisch aan.
     *
     * @param user
     * @param product
     * @param amount
     * @throws StockException Indien niet aanwezig in de stock
     */
    public void updateCart(User user, Product product, int amount) throws StockException
    {
        int amountDelta = 0;
        int currentAmount = user.getCart().getCartItemAmount(product);
        amountDelta = amount - currentAmount;
        stockController.updateStockCount(product, amountDelta);
        userController.updateCart(user, product, amountDelta);
    }

    /**
     * Zoek de gebruiker op met deze username Deze username zal in de
     * HTTPSession gestockeerd worden.
     *
     * @param username
     * @return
     */
    public User getUser(String username) throws LoginException
    {
        return userController.getUser(username);
    }

    /**
     * Geef de naam terug van de webshop
     *
     * @return
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Geef alle gebruikers van het systeem terug
     *
     * @return
     */
    public Map<String, User> getUsers()
    {
        return userController.getUsers();
    }

    /**
     * Maakt een bestelling op op basis van de huidige winkelkarinhoud van deze
     * gebruiker.
     */
    public Order checkOut(User user)
    {
        return userController.checkOut(user);
    }

    /**
     * Voeg een product toe aan de stock. Deze functie wordt gebruikt door de
     * backend.
     *
     * @param productDescription
     * @param productPrice
     * @param productCategory
     * @param amount
     * @throws StockException
     */
    public void addProduct(String productDescription, Double productPrice, String productCategory, Integer amount) throws StockException
    {
        stockController.addProduct(productDescription, productPrice, productCategory, amount);
    }

    /**
     * Wijzig een product in de catalogus
     *
     * @param product
     * @throws StockException
     */
    public void updateProduct(Product product, String newProductDescription, Double newProductPrice, String newProductCategory) throws StockException
    {
        if(newProductPrice < 0)
                throw new StockException("Productprijs kan niet negatief zijn");
        
        synchronized(product)
        {
            int amount = stockController.getStockCount(product);
            // verwijder product uit de stock
            // verwijdert ook de categorie als dit het laatste product was            
            stockController.removeProduct(product);
            
            product.setDescription(newProductDescription);
            product.setPrice(newProductPrice);            
            product.setCategoryName(newProductCategory);
            
            // voeg product toe aan de stock
            // indien het product in een nieuwe categorie zit,
            // wordt automatisch een nieuwe categorie aangemaakt
            stockController.updateProduct(product, amount);
        }
    }

    /**
     * Verwijder een product uit de catalogus
     *
     * @param product
     */
    public void removeProduct(Product product) throws StockException
    {
        stockController.removeProduct(product);
    }

    /**
     * Wijzig de stockcount voor een product
     *
     * @param product
     * @param amount
     * @throws StockException
     */
    public void updateStockCount(Product product, Integer amount) throws StockException
    {
        this.stockController.updateStockCount(product, amount);
    }

    /**
     * Geef de stockcount voor een product
     *
     * @param product
     * @return
     */
    public Integer getStockCount(Product product)
    {
        return stockController.getStockCount(product);
    }

    /**
     * Mockdata initialisatiefunctie
     */
    private void initStore()
    {
        // Maak een gewone gebruiker
        Address address1 = new Address("Nationalestraat", "5", "2000", "Antwerpen");
        Person person1 = new Person("Jan", "Peeters", address1);
        User user1 = new User(person1, "jan.peeters@student.kdg.be", "jan", Role.CUSTOMER);

        // Maak een superuser
        Address address2 = new Address("Nationalestraat", "5", "2000", "Antwerpen");
        Person person2 = new Person("Wouter", "Deketelaere", address2);
        User user2 = new User(person2, "wouter.deketelaere@kdg.be", "jef", Role.CUSTOMER);

        addUser(user1);
        addUser(user2);

        // update de gebruiker met een nieuwe rol
        updateUser(user2, user2.getPerson(), Role.ADMIN);
        // update een gebruiker met een nieuw wachtwoord                
        try
        {
            updatePassword(user2, "jef", "wouter");
            checkLogin(user2.getUsername(), "wouter");
        }
        catch (LoginException ex)
        {
            Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
        }

        // vraag product op
        Product product = getProductByDescription("Set weerstanden");
        try
        {
            // update een product met een "nieuwe" beschrijving
            updateProduct(product, "Set weerstanden", product.getPrice(), "Componenten");
        }
        catch (StockException ex)
        {
            Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}