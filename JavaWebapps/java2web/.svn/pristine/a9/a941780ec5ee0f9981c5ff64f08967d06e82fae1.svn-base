/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.test;

import be.kdg.shop.facade.Store;
import be.kdg.shop.model.user.User;
import java.util.TreeMap;

/**
 *
 * @author deketelw
 */
public class StoreTester
{

    public static void main(String args[]) throws InterruptedException
    {
        Store store = new Store();
        Thread[] ts = new Thread[100];
        for (int i = 0; i < 100; i++)
        {
            ts[i] = new Thread(new WebUser(store, "ID" + i + ":", "Set weerstanden"));
            ts[i].start();            
            
        }
        for (int i = 0; i < 100; i++)
        {
            ts[i].join();
            System.out.println("Thread " + i + " stopped");
        }
        TreeMap<String, User> orderedUsers = new TreeMap<String, User>();
        orderedUsers.putAll(store.getUsers());
        for (User user : orderedUsers.values())
        {
            System.out.println(user.getUsername());
        }
        System.exit(0);
    }
}
