/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.springjsfrest.model;

/**
 *
 * @author wouter
 */
public class Meting
{
    private final int m_key;
    private final double temperatuur;
    private final double luchtvochtigheid;

    public Meting(int m_key, double temperatuur, double luchtvochtigheid)
    {
        this.m_key = m_key;
        this.temperatuur = temperatuur;
        this.luchtvochtigheid = luchtvochtigheid;
    }

    public int getM_key()
    {
        return m_key;
    }

    public double getTemperatuur()
    {
        return temperatuur;
    }

    public double getLuchtvochtigheid()
    {
        return luchtvochtigheid;
    }
}
