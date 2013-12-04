/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.spring103.model;

/**
 *
 * @author wouter
 */
public interface LoginService
{
    public boolean checkLogin(String username, String password);
}
