package be.kdg.model.agendamodel;

import be.kdg.model.agendamodel.afspraken.Afspraak;
import be.kdg.model.agendamodel.afspraken.AfspraakManager;
import be.kdg.model.agendamodel.afspraken.Datum;
import be.kdg.model.agendamodel.users.UserManager;
import java.util.List;

public class CalendarController
{
    private UserManager userManager;
    private AfspraakManager afspraakManager;

    public CalendarController()
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
