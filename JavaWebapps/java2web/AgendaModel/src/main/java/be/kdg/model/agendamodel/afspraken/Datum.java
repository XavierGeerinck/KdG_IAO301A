package be.kdg.model.agendamodel.afspraken;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public final class Datum implements Comparable<Datum>, Serializable
{

    private final int day;
    private final int month;
    private final int year;

    public Datum()
    {
        Calendar calendar = GregorianCalendar.getInstance();
        this.day = calendar.get(Calendar.DAY_OF_MONTH);
        this.month = calendar.get(Calendar.MONTH) + 1;
        this.year = calendar.get(Calendar.YEAR);
    }

    public Datum(int day, int month, int year)
    {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Datum(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        this.day = calendar.get(Calendar.DAY_OF_MONTH);
        this.month = calendar.get(Calendar.MONTH) + 1;
        this.year = calendar.get(Calendar.YEAR);
    }

    public Datum(Datum other)
    {
        if (other == null)
        {
            throw new IllegalArgumentException("cannot create date from null");
        }
        this.day = other.day;
        this.month = other.month;
        this.year = other.year;
    }

    public int getDay()
    {
        return day;
    }

    public int getMonth()
    {
        return month;
    }

    public int getYear()
    {
        return year;
    }

    public int compareTo(Datum date)
    {
        int vglYear = year - date.year;
        if (vglYear != 0)
        {
            return vglYear;
        }
        int vglMonth = month - date.month;
        if (vglMonth != 0)
        {
            return vglMonth;
        }
        return day - date.day;
    }

    @Override
    public String toString()
    {
        String dayStr = String.valueOf(day), monthStr = String.valueOf(month),  yearStr = String.valueOf(year);
        if(day < 10)
            dayStr = "0" + dayStr;
        if(month < 10)
            monthStr = "0" + monthStr;
        
        return dayStr + "/" + monthStr + "/" + yearStr;
    }

    private int daysInMonth(int month, int year)
    {
        switch (month)
        {
            case 1:
                return 31;
            case 2:
            {
                if (year % 4 == 0 && year % 100 != 0)
                {
                    return 29;
                } else
                {
                    return 28;
                }
            }
            case 3:
                return 31;
            case 4:
                return 30;
            case 5:
                return 31;
            case 6:
                return 30;
            case 7:
                return 31;
            case 8:
                return 31;
            case 9:
                return 30;
            case 10:
                return 31;
            case 11:
                return 30;
            case 12:
                return 31;
            default:
                return 0;
        }
    }

    public boolean isValid()
    {
        if (day < 1)
        {
            return false;
        }
        if (day > daysInMonth(month, year))
        {
            return false;
        }
        if (month < 1)
        {
            return false;
        }
        if (month > 12)
        {
            return false;
        }
        return true;
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
        final Datum other = (Datum) obj;
        if (this.day != other.day)
        {
            return false;
        }
        if (this.month != other.month)
        {
            return false;
        }
        if (this.year != other.year)
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 97 * hash + this.day;
        hash = 97 * hash + this.month;
        hash = 97 * hash + this.year;
        return hash;
    }
}
