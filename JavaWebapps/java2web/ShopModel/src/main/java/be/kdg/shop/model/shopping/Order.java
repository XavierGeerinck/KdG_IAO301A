package be.kdg.shop.model.shopping;

import java.util.*;

public class Order
{
    private Collection<LineItem> lineItems;
    private Date orderDate;

    public Order()
    {
        orderDate = new Date();
        lineItems = new ArrayList<LineItem>();
    }

    /**
     * Bereken de totale prijs voor die order.
     * 
     * @return 
     */
    public double getTotalPrice()
    {
        double totalPrice = 0.0d;
        for(LineItem lineItem: lineItems)
            totalPrice += lineItem.getPrice();
        return totalPrice;
    }

    /**
     * 
     * @return 
     */
    public Date getOrderDate()
    {
        return this.orderDate;
    }

    public Collection<LineItem> getLineItems()
    {
        return lineItems;
    }
    
    public synchronized void addLineItem(LineItem lineItem)
    {
        this.lineItems.add(lineItem);
    }
    
}