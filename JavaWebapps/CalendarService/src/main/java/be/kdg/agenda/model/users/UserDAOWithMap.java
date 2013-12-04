package be.kdg.agenda.model.users;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class UserDAOWithMap implements UserDAO
{

    private Map<String, User> users;

    public UserDAOWithMap()
    {
        this.users = Collections.synchronizedMap(new HashMap<String, User>());
        initData();
    }

    private void initData()
    {
        users.put("ikke", new User("ikke", "ikke"));
        users.put("bla", new User("bla", "bla"));
    }

    public void create(User user)
    {
        users.put(user.getUsername(), new User(user));
    }

    public void update(User user)
    {
        users.put(user.getUsername(), new User(user));
    }

    public User retrieve(String username)
    {
        User user = users.get(username);
        if (user == null)
        {
            return null;
        }
        return new User(user);
    }

    public void delete(User user)
    {
        users.remove(user.getUsername());
    }
}
