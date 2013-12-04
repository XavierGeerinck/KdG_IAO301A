/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.shop.model.stock.exceptions;

/**
 *
 * @author deketelw
 */
public class StockException extends Exception
{
    /**
     * Deze exception wordt gesmeten wanneer iets fout gaat in de Stock.
     * Bijvoorbeeld wanneer de een geven product niet meer voorradig is.
     * @param message 
     */
    public StockException(String message)
    {
        super(message);
    }
}
