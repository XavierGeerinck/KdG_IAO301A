package be.kdg.shop.controller;

import be.kdg.shop.model.stock.*;
import be.kdg.shop.model.stock.exceptions.StockException;
import be.kdg.shop.persistence.dao.interfaces.StockDAO;
import be.kdg.shop.persistence.factory.DAOFactory;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StockController
{
    private final StockDAO stockDAO;

    public StockController()
    {
        this.stockDAO = DAOFactory.instance(DAOFactory.MapDAOFActory).getStockDAO();
        this.initStock();
    }

    /**
     * Vraag alle product op van een bepaalde categorie
     *
     * @param categoryName
     * @return
     */
    public Collection<Product> getProductsOfCategory(String categoryName)
    {
        return this.stockDAO.getProductsByCategoryName(categoryName);
    }

    /**
     * Vraag alle categorieën op die er zijn
     *
     * @return
     */
    public Collection<String> getCategories()
    {
        return this.stockDAO.getCategories();
    }

    /**
     * Vraag een product op aan de hand van de productbeschrijving
     *
     * @param productName unieke productnaam
     * @return
     */
    public Product getProductByDescription(String productName)
    {
        return this.stockDAO.getProductByDescription(productName);
    }

    /**
     * Wijzig de stockcount voor een product. Wordt opgeroepen indien een
     * gebruiker een product toevoegt/verwijdert uit zijn winkelkarretje.
     *
     * @param product
     * @param amount
     * @throws StockException Product bestaat niet of niet voldoende aanwezig
     */
    public void updateStockCount(Product product, int amount) throws StockException
    {
        this.stockDAO.updateStockItem(product, amount);
    }

    /**
     * Geeft de stockcount voor een product
     *
     * @param product
     * @return
     */
    public Integer getStockCount(Product product)
    {
        return this.stockDAO.getStockcount(product);
    }

    /**
     * Voeg een product toe aan de catalogus
     *
     * @param categoryName
     * @param description
     * @param price
     * @param amount
     * @throws StockException
     */
    public void addProduct(String description, Double price, String categoryName, int amount) throws StockException
    {
        Product product = new Product(description, price, categoryName);
        this.stockDAO.addProduct(product, amount);
    }
    
    /**
     * Update een product in de catalogus
     *
     * @param product
     * @throws StockException
     */
    public void updateProduct(Product product, int amount) throws StockException
    {
        this.stockDAO.addProduct(product, amount);
    }

    public void removeProduct(Product product) throws StockException
    {
        this.stockDAO.removeProduct(product);
    }

    private void initStock()
    {
        try
        {
            addProduct("Set weerstanden", 5.1d, "Weerstanden", 250);
            addProduct("Set condensatoren", 10.0d, "Componenten", 500);
            addProduct("Zenderdiode 12V 4A", 7.8d, "Componenten", 10);
            addProduct("Zenderdiode 14,4V 5A", 20.0d, "Componenten", 15);

            addProduct("Ronde ferrietmagneet 10 mm", 10.0d, "Magneten", 50);
            addProduct("Ronde ferrietmagneet 20 mm", 4.4d, "Magneten", 100);
            addProduct("Ronde ferrietmagneet 50 mm", 5.7d, "Magneten", 200);
            addProduct("Ronde Neodymiummagneet 20 mm", 7.2d, "Magneten", 250);
        }
        catch (StockException ex)
        {
            Logger.getLogger(StockController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}