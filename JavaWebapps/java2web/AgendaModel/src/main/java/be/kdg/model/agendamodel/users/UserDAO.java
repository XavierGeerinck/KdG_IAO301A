package be.kdg.model.agendamodel.users;

public interface UserDAO
{
    void create(User user);

    void update(User user);

    User retrieve(String username);

    void delete(User user);
}
