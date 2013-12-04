package be.kdg.agenda.model.users;

import be.kdg.agenda.model.users.User;

public interface UserDAO
{
    void create(User user);

    void update(User user);

    User retrieve(String username);

    void delete(User user);
}
