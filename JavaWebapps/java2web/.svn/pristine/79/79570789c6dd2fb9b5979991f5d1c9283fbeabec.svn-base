/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.shop.persistence.dao.impl;

import be.kdg.shop.model.stock.Product;
import be.kdg.shop.model.stock.StockItem;
import be.kdg.shop.model.stock.exceptions.StockException;
import be.kdg.shop.persistence.dao.interfaces.StockDAO;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author wouter
 */
public class MapStockDAO implements StockDAO
{
    private final Map<String, Product> productsByDescription;
    private final Map<String, Collection<Product>> productsByCategoryName;
    private final Map<Product, StockItem> stockItemsByProduct;

    public MapStockDAO()
    {
        this.productsByDescription = new ConcurrentHashMap<String, Product>();
        this.productsByCategoryName = new ConcurrentHashMap<String, Collection<Product>>();
        this.stockItemsByProduct = new ConcurrentHashMap<Product, StockItem>();
    }

    /**
     * Haal een product op a.d.h.v. zijn unieke beschrijving
     * @param description
     * @return 
     */
    public Product getProductByDescription(String description)
    {
        return this.productsByDescription.get(description);
    }

    /**
     * Haal de producten op a.d.h.v. de categorienaam
     * @param categoryName
     * @return 
     */
    public Collection<Product> getProductsByCategoryName(String categoryName)
    {
        return this.productsByCategoryName.get(categoryName);
    }

    /**
     * Haal alle categorieën op die bekend zijn in het systeem. Deze functie
     * wordt gebruikt in de backend
     * @return 
     */
    public Collection<String> getCategories()
    {
        return this.productsByCategoryName.keySet();
    }

    /**
     * Voeg een product toe aan de stock. Maakt ook indien nodig een nieuwe
     * categorie als deze nog niet bestond
     * @param product
     * @param amount
     * @throws StockException 
     */
    public void addProduct(Product product, int amount) throws StockException
    {
        synchronized(this)
        {
            updateStockItem(product, amount);
            this.productsByDescription.put(product.getDescription(), product);
            addProductToCategory(product);
        }
    }
    
    /**
     * Verwijdert een product uit de stock. Verwijdert indien nodig ook de 
     * categorie indien deze geen producten meer heeft.
     * @param product 
     * @throws StockException indien het product niet (meer) aanwezig is
     */
    public void removeProduct(Product product) throws StockException
    {
        synchronized(this)
        {
            if(stockItemsByProduct.containsKey(product))
            {
                this.stockItemsByProduct.remove(product);
                this.productsByDescription.remove(product.getDescription());
                removeProductFromCategory(product);
            }
            else
                throw new StockException("Product niet gevonden in stock");
        }
    }
    
    /**
     * Wijzigt de stockcount voor een gegeven product
     * @param product
     * @param amount
     * @throws StockException 
     */
    public void updateStockItem(Product product, Integer amount) throws StockException
    {
        synchronized(stockItemsByProduct)
        {
            StockItem item = this.stockItemsByProduct.get(product);        
            if (item == null)
            {
                // Er was nog geen StockItem voor dit product
                this.stockItemsByProduct.put(product, new StockItem(amount));
            }
            else 
            {
                // Er is wel reeds een StockItem voor dit product
                int newAmount = item.getAmount() - amount;
                if (newAmount >= 0)
                {
                    stockItemsByProduct.put(product, new StockItem(newAmount));
                }
                else
                    throw new StockException("De voorraad voor het product " + product.getDescription() + " bedraagt " + item.getAmount());
            }
        }
    }

    /**
     * Geef de huidige stockcount voor een gegeven product
     * @param product
     * @return 
     */
    public Integer getStockcount(Product product)
    {
        synchronized(stockItemsByProduct)
        {
            return stockItemsByProduct.get(product).getAmount();
        }
    }
    
    /**
     * Utility functie om automatisch een product te toe te voegen aan een categorie
     * Deze voegt ook automatisch de categorie toe indien deze nog niet bestaat
     * @param product 
     */
    private void addProductToCategory(Product product)
    {
        if(!this.productsByCategoryName.containsKey(product.getCategoryName()))
            this.productsByCategoryName.put(product.getCategoryName(),new HashSet<Product>());
        
        this.productsByCategoryName.get(product.getCategoryName()).add(product);
    }
    
    /**
     * Utility functie om automatisch een product te verwijderen uit een categorie
     * Deze verwijdert ook automatisch de categorie indien er geen producten
     * meer voor bestaan.
     * @param product 
     */
    private void removeProductFromCategory(Product product)
    {
        this.productsByCategoryName.get(product.getCategoryName()).remove(product);
        
        if(productsByCategoryName.get(product.getCategoryName()).isEmpty())
        {
            productsByCategoryName.remove(product.getCategoryName());
        }
    }
    
}
