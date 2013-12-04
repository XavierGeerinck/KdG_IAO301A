package be.kdg.agenda.service.api;

import be.kdg.agenda.model.afspraken.Afspraak;
import be.kdg.agenda.model.afspraken.AfspraakDAO;
import be.kdg.agenda.model.afspraken.AfspraakDAOWithMap;
import be.kdg.agenda.model.afspraken.Datum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Created by xaviergeerinck on 28/11/13.
 */
public interface AfspraakService {
    public void addAfspraak(Afspraak afspraak);

    public List<Afspraak> zoekAfspraak(Datum date, String username);

    public void removeAfspraak(Afspraak afspraak);
}
