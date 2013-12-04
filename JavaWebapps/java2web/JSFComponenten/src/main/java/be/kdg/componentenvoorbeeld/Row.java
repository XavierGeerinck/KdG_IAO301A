/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.componentenvoorbeeld;

/**
 *
 * @author wouter
 */
public class Row
{
    private Integer number;
    private boolean visible;
    
    public Row(Integer number)
    {
        this.number = number;
        this.visible = true;        
    }

    public Integer getNumber()
    {
        return number;
    }

    public void setNumber(Integer number)
    {
        this.number = number;
    }
    
    public boolean isVisible()
    {
        return visible;
    }

    public void setVisible(boolean visible)
    {
        this.visible = visible;
    }
}
