package be.kdg.model.agendamodel.afspraken;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class AfspraakManager
{

    private AfspraakDAO afspraakDAO;

    public AfspraakManager()
    {
        this.afspraakDAO = new AfspraakDAOWithMap();
    }

    public void addAfspraak(Afspraak afspraak)
    {
        afspraakDAO.create(afspraak);
    }

    public List<Afspraak> zoekAfspraak(Datum date, String username)
    {
        Set<Afspraak> afspraaks = afspraakDAO.retrieveByDateAndUsername(date, username);
        List<Afspraak> sortedafspraaks = new ArrayList<Afspraak>(afspraaks);
        Collections.sort(sortedafspraaks);
        return sortedafspraaks;
    }

    public void removeAfspraak(Afspraak afspraak)
    {
        afspraakDAO.delete(afspraak);
    }
}
