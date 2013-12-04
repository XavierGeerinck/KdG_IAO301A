/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.shop.persistence.dao.interfaces;

import be.kdg.shop.model.stock.Product;
import be.kdg.shop.model.stock.exceptions.StockException;
import java.util.Collection;

/**
 *
 * @author wouter
 */
public interface StockDAO
{
    public Product getProductByDescription(String description);

    public Collection<Product> getProductsByCategoryName(String categoryName);

    public Collection<String> getCategories();

    public void addProduct(Product product, int amount) throws StockException;
    
    public void removeProduct(Product product) throws StockException;
    
    public void updateStockItem(Product product, Integer amount) throws StockException;

    public Integer getStockcount(Product product);
    
}
