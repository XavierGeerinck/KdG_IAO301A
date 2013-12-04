package be.kdg.agenda.service.impl;

import be.kdg.agenda.model.afspraken.Afspraak;
import be.kdg.agenda.model.afspraken.AfspraakDAO;
import be.kdg.agenda.model.afspraken.AfspraakDAOWithMap;
import be.kdg.agenda.model.afspraken.Datum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class AfspraakServiceImpl
{

    private AfspraakDAO afspraakDAO;

    public AfspraakServiceImpl()
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
