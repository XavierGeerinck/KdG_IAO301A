/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author wouter
 */

@Named("loginController")
@ApplicationScoped
public class LoginControllerImpl implements LoginController
{

    private Map<String, String> usernames;

    public LoginControllerImpl()
    {
        usernames = new ConcurrentHashMap<String, String>();
        usernames.put("wouter.deketelaere@kdg.be", "wouter");
        usernames.put("jan.peeters@student.kdg.be", "jan");
    }

    @Override
    public boolean checkLogin(String username, String password)
    {
        if (usernames.containsKey(username))
        {
            return usernames.get(username).equals(password);
        } 
        else
        {
            return false;
        }
    }
}
