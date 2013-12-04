/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.spring102;

import javax.inject.Named;

/**
 *
 * @author wouter
 */
@Named("quest2")
public class SlayDragonQuest implements Quest
{

    @Override
    public void embark()
    {
        System.out.println("Slaying that dragon right now");
    }
    
}
