package be.kdg.hiddenfields.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Deze klasse wordt maar door 1 gebruiker (thread) gebruikt.
 * Daarom is ze niet specifiek thread-safe gemaakt.
 */
public class Mandje implements Serializable
{
    private List<String> aankopen;

    public Mandje()
    {
        aankopen = new ArrayList<String>();
    }

    public List<String> getAankopen()
    {
        return Collections.unmodifiableList(aankopen);
    }

    public void add(String film)
    {
        aankopen.add(film);
    }

    public void remove(String film)
    {
        aankopen.remove(film);
    }

}