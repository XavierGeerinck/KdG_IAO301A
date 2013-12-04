/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.spring103.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;

/**
 *
 * @author wouter
 */

@Service("loginService")
public class LoginServiceImpl implements LoginService
{
    private Map<String, String> usernames;

    public LoginServiceImpl()
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
