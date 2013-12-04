package be.kdg.agenda.model.users;

public class UserManager
{
    private UserDAO userDao;

    public UserManager()
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
