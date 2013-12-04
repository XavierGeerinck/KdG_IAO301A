/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.priemgetallenmodel;

/**
 *
 * @author wouter
 */
public class Priemgetallen
{

    private Priemgetallen()
    {
    }

    public static int vindVorigPriemgetal(int getal)
    {
        do
        {
            getal--;
        } while (Priemgetallen.isGeenPriemgetal(getal) && getal >= 2);
        return getal < 2 ? 2 : getal;
    }

    public static int vindVolgendPriemgetal(int getal)
    {
        do
        {
            getal++;
        } while (Priemgetallen.isGeenPriemgetal(getal));
        return getal;
    }

    private static boolean isGeenPriemgetal(int getal)
    {
        for (int i = 2; i <= Math.sqrt(getal); i++)
        {
            if (getal % i == 0)
            {
                return true;
            }
        }
        return false;
    }
}