package be.kdg.shop.model.stock;

public final class StockItem
{
    private final Integer amount;

    public StockItem(Integer amount)
    {
        this.amount = amount;
    }

    /**
     * Geef de hoeveelheid weer voor dit stockitem
     * @return 
     */
    public Integer getAmount()
    {
        return this.amount;
    }
}