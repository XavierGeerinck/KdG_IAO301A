/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.spring101;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author wouter
 */
public class TestKnights
{

    public static void main(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("be/kdg/spring/app-context.xml");
        Knight knight = (Knight) context.getBean("knight");
        
        knight.embarkOnQuest();
    }
}
