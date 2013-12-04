package be.kdg.agenda.model.users;

public interface UserDAO
{
    void create(User user);

    void update(User user);

    User retrieve(String username);

    void delete(User user);
}
