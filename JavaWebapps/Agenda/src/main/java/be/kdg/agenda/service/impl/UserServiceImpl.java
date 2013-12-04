package be.kdg.agenda.service.impl;

import be.kdg.agenda.model.users.User;
import be.kdg.agenda.model.users.UserDAO;
import be.kdg.agenda.model.users.UserDAOWithMap;

public class UserServiceImpl
{
    private UserDAO userDao;

    public UserServiceImpl()
    {
        this.userDao = new UserDAOWithMap();
    }

    public boolean checkUsernamePassword(String username, String password)
    {
        User user = userDao.retrieve(username);
        if (user == null)
        {
            return false;
        }
        if (user.getPassword().equals(password))
        {
            return true;
        }
        return false;
    }
}
