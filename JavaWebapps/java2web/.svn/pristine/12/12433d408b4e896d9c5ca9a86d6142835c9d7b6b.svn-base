package be.kdg.model.agendamodel.afspraken;

import java.io.Serializable;

public final class Tijdstip implements Comparable<Tijdstip>, Serializable
{
    private final int hour;
    private final int minutes;

    public Tijdstip()
    {
        this.hour = 0;
        this.minutes = 0;
    }

    public Tijdstip(int hour, int minutes)
    {
        this.hour = hour;
        this.minutes = minutes;
    }

    public Tijdstip(Tijdstip other)
    {
        if (other == null)
        {
            throw new IllegalArgumentException("cannot create timestamp from null");
        }
        this.hour = other.hour;
        this.minutes = other.minutes;
    }

    public int getHour()
    {
        return hour;
    }

    public int getMinutes()
    {
        return minutes;
    }

    public int compareTo(Tijdstip timestamp)
    {
        int vglHour = hour - timestamp.hour;
        if (vglHour != 0)
        {
            return vglHour;
        }
        return minutes - timestamp.minutes;
    }

    @Override
    public String toString()
    {
        String hourStr = String.valueOf(hour), minutesStr = String.valueOf(minutes);
        if(hour < 10)
            hourStr = "0" + hourStr;
        if(minutes < 10)
            minutesStr = "0" + minutesStr;
        
        return hourStr + ":" + minutesStr;
    }

    public boolean isValid()
    {
        return !(hour < 0 || hour > 23 || minutes < 0 || minutes > 59);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Tijdstip other = (Tijdstip) obj;
        if (this.hour != other.hour)
        {
            return false;
        }
        if (this.minutes != other.minutes)
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode()
    {
        int hash = 3;
        hash = 17 * hash + this.hour;
        hash = 17 * hash + this.minutes;
        return hash;
    }
}
