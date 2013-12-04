package be.kdg.shop.model.user;

public final class Person
{
    private final Address address;
    private final String firstname;
    private final String lastname;

    public Person(String firstname, String lastname,Address address)
    {
        this.address = address;
        this.firstname = firstname;
        this.lastname = lastname;
    }
    
    /**
     * 
     * @return 
     */
    public String getFirstname()
    {
        return this.firstname;
    }

    /**
     * 
     * @return 
     */
    public String getLastname()
    {
        return this.lastname;
    }

    public Address getAddress()
    {
        return address;
    }
    
}