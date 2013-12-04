package be.kdg.webapps101.model;

import java.util.*;

public class ProductList
{
    private List<Product> products;

    public static ProductList create()
    {
        ProductList productList = new ProductList();
        productList.add(new Product(1, "product 1"));
        productList.add(new Product(2, "product 2"));
        productList.add(new Product(3, "product 3"));
        productList.add(new Product(4, "product 4"));
        productList.add(new Product(5, "product 5"));
        productList.add(new Product(6, "product 6"));
        productList.add(new Product(7, "product 7"));
        return productList;
    }

    private ProductList()
    {
        products = new ArrayList<Product>();
    }

    public void add(Product product)
    {
        products.add(product);
    }

    public void remove(int productId)
    {
        Product product = new Product(productId, "");
        products.remove(product);
    }

    public Collection getProducts()
    {
        return Collections.unmodifiableCollection(products);
    }

    public int size()
    {
        return products.size();
    }

    public Product getProduct(int index)
    {
        return products.get(index);
    }
}
