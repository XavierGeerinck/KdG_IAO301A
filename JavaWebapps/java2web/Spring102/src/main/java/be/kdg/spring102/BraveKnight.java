/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.spring102;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author wouter
 */
@Named("knight")
public class BraveKnight implements Knight
{
    @Autowired
    @Qualifier("quest2")
    private Quest quest;
        
 
    @PostConstruct
    public void birth()
    {
        System.out.println("A knight is born");
    }
    
    
    @PreDestroy
    public void death()
    {
        System.out.println("The knight died a horrible and painful death "
                + "while being on stupid quest serving no purpose whatsoever.");
    }
    
    @Override
    public void embarkOnQuest()
    {
        quest.embark();
    }
}
