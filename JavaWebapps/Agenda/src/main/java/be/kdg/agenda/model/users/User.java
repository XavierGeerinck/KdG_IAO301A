package be.kdg.agenda.model.users;

public final class User
{
    private final String username;
    private final String password;

    /**
     * Maak een nieuwe gebruiker met gebruikersnaam en password
     * @param username
     * @param password 
     */
    public User(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    /**
     * Copy constructor voor een gebruiker
     * @param other 
     */
    User(User other)
    {
        if (other == null)
        {
            throw new IllegalArgumentException("cannot create user from null");
        }
        this.username = other.username;
        this.password = other.password;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }
}
