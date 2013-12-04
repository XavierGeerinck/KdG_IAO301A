package be.kdg.shop.model.shopping;

public final class LineItem
{
    private final String productDescription;
    private final int amount;
    private final double price;

    public LineItem(String productDescription, int amount, double price)
    {
        this.productDescription = productDescription;
        this.amount = amount;
        this.price = price;
    }

    /**
     * 
     * @return 
     */
    public int getAmount()
    {
        return amount;
    }

    /**
     * 
     * @return 
     */
    public double getPrice()
    {
        return price;
        
    }

    public String getProductDescription()
    {
        return productDescription;
    }
}