/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.priemgetallenmodel;

import java.io.Serializable;

/**
 *
 * @author wouter
 */
public class PriemgetallenBean implements Serializable
{
    private int huidigeGetal;

    public PriemgetallenBean()
    {
        this.huidigeGetal = 2;
    }

    public void vorige()
    {
        huidigeGetal = Priemgetallen.vindVorigPriemgetal(huidigeGetal);
    }

    public void volgende()
    {
        huidigeGetal = Priemgetallen.vindVolgendPriemgetal(huidigeGetal);
    }

    public int getGetal()
    {
        return huidigeGetal;
    }
}
