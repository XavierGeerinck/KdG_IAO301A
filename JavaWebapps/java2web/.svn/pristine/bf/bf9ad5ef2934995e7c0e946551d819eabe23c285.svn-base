package be.kdg.shop.model.shopping;

import java.util.*;
import be.kdg.shop.model.stock.*;
import java.util.concurrent.ConcurrentHashMap;

public final class Cart
{
    private final Map<Product, CartItem> cartItems;

    public Cart()
    {
        this.cartItems = new ConcurrentHashMap<Product, CartItem>();
    }

    public Map<Product, CartItem> getCartItems()
    {
        return this.cartItems;
    }

    /**
     * Hiermee kan je een product toevoegen of verwijderen uit het
     * winkelkarretje.  
     * @param amount kan dus ook een negatieve getal zijn.
     * @param product
     * @param amount
     */
    public void updateProduct(final Product product, final Integer amount)
    {
        CartItem cartItem;
        
        if(cartItems.keySet().contains(product))
        {
            cartItem = cartItems.get(product);
            int newAmount = cartItem.getAmount() + amount;
            if(newAmount > 0)
            {
                // cartItem is final daarom constructor aanroepen
                cartItem = new CartItem(product, newAmount);
                cartItems.put(product, cartItem);
            }
            else
                cartItems.remove(product);
        }
        else
        {
            cartItem = new CartItem(product, amount);
            cartItems.put(product, cartItem);
        }
    }

    public Double getTotalPrice()
    {
        Double sum = 0.0d;
        for(CartItem cartItem: cartItems.values())
        {
            sum += cartItem.getPrice();
        }        
        return sum;
    }

    public int getCartItemAmount(Product product)
    {
        if(cartItems.containsKey(product))
            return this.cartItems.get(product).getAmount();
        return 0;
    }

    public void clearCart()
    {
        cartItems.clear();
    }
}