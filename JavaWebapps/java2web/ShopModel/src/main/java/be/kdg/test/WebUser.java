/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.test;

import be.kdg.shop.facade.Store;
import be.kdg.shop.model.user.Address;
import be.kdg.shop.model.user.Person;
import be.kdg.shop.model.user.Role;
import be.kdg.shop.model.user.User;

/**
 *
 * @author deketelw
 */
public class WebUser implements Runnable
{
    private Store store;
    private String webuserID;
    private final String description;

    public WebUser(Store store, String webuserID, String description)
    {
        this.store = store;
        this.webuserID = webuserID;
        this.description = description;
    }
    
    @Override
    public void run()
    {
//        while(!Thread.interrupted())
//        {
//            Product product = store.getProductByDescription(description);
//            System.out.println(webuserID + " " + product.getDescription());
//            try
//            {
//                Thread.sleep(100);
//            } catch (InterruptedException ex)
//            {
//               break;
//            }
//        }
//        
        for (int i = 0; i < 100; i++)
        {        
            Address address = new Address(webuserID, webuserID, webuserID, webuserID);
            Person person = new Person(webuserID,webuserID,address);
            User user = new User(person,webuserID+i,webuserID, Role.CUSTOMER);
            store.addUser(user);            
            try
            {
                Thread.sleep(100);
            } catch (InterruptedException ex)
            {
               break;
            }
        }
    }
    
}
