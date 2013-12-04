package be.kdg.agenda.service.impl;

import be.kdg.agenda.model.afspraken.Afspraak;
import be.kdg.agenda.model.afspraken.AfspraakManager;
import be.kdg.agenda.model.afspraken.Datum;
import be.kdg.agenda.model.users.UserManager;

import java.util.List;

/**
 * Created by xaviergeerinck on 28/11/13.
 */
public class CalendarService {
    private UserManager userManager;
    private AfspraakManager afspraakManager;

    public CalendarService()
    {
        this.userManager = new UserManager();
        this.afspraakManager = new AfspraakManager();
    }

    public boolean checkUsernamePassword(String username, String password)
    {
        return userManager.checkUsernamePassword(username, password);
    }

    public void addAfspraak(Afspraak afspraak)
    {
        afspraakManager.addAfspraak(afspraak);
    }

    public List<Afspraak> zoekAfspraak(Datum date, String username)
    {
        return afspraakManager.zoekAfspraak(date, username);
    }

    public void removeAfspraak(Afspraak afspraak)
    {
        afspraakManager.removeAfspraak(afspraak);
    }
}
