package be.kdg.agenda.model.afspraken;

import java.io.Serializable;

public class Afspraak implements Comparable<Afspraak>, Serializable
{

    private int id;
    private String username;
    private Datum date;
    private Tijdstip from;
    private Tijdstip until;
    private String description;

    public Afspraak(String username, Datum date, Tijdstip from, Tijdstip until, String description)
    {
        this(-1, username, date, from, until, description);
    }

    Afspraak(int id, String username, Datum date, Tijdstip from, Tijdstip until, String description)
    {
        this.id = id;
        this.username = username;
        this.date = date;
        this.from = from;
        this.until = until;
        this.description = description;
    }

    public Afspraak(Afspraak other)
    {
        if (other == null)
        {
            throw new IllegalArgumentException("cannot create afspraak from null");
        }
        this.id = other.id;
        this.username = other.username;
        this.date = new Datum(other.date);
        this.from = new Tijdstip(other.from);
        this.until = new Tijdstip(other.until);
        this.description = other.description;
    }

    public int getId()
    {
        return id;
    }

    void setId(int id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public Datum getDate()
    {
        return date;
    }

    public void setDate(Datum date)
    {
        this.date = date;
    }

    public Tijdstip getFrom()
    {
        return from;
    }

    public void setFrom(Tijdstip from)
    {
        this.from = from;
    }

    public Tijdstip getUntil()
    {
        return until;
    }

    public void setUntil(Tijdstip until)
    {
        this.until = until;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public int compareTo(Afspraak afspraak)
    {
        int vglUsername = username.compareTo(afspraak.username);
        if (vglUsername != 0)
        {
            return vglUsername;
        }
        int vglDate = date.compareTo(afspraak.date);
        if (vglDate != 0)
        {
            return vglDate;
        }
        int vglFrom = from.compareTo(afspraak.from);
        return vglFrom;
    }

    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof Afspraak))
        {
            return false;
        }

        final Afspraak afspraak = (Afspraak) o;

        if (id != afspraak.id)
        {
            return false;
        }
        if (date != null ? !date.equals(afspraak.date) : afspraak.date != null)
        {
            return false;
        }
        if (description != null ? !description.equals(afspraak.description) : afspraak.description != null)
        {
            return false;
        }
        if (until != null ? !until.equals(afspraak.until) : afspraak.until != null)
        {
            return false;
        }
        if (username != null ? !username.equals(afspraak.username) : afspraak.username != null)
        {
            return false;
        }
        if (from != null ? !from.equals(afspraak.from) : afspraak.from != null)
        {
            return false;
        }

        return true;
    }

    public int hashCode()
    {
        int result;
        result = id;
        result = 29 * result + (username != null ? username.hashCode() : 0);
        result = 29 * result + (date != null ? date.hashCode() : 0);
        result = 29 * result + (from != null ? from.hashCode() : 0);
        result = 29 * result + (until != null ? until.hashCode() : 0);
        result = 29 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
