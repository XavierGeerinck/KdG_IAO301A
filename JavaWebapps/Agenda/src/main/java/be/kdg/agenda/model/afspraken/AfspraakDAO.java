package be.kdg.agenda.model.afspraken;

import be.kdg.agenda.model.afspraken.Afspraak;
import be.kdg.agenda.model.afspraken.Datum;

import java.util.Set;

public interface AfspraakDAO
{

    void create(Afspraak afspraak);

    void update(Afspraak afspraak);

    Afspraak retrieve(int id);

    Set<Afspraak> retrieveByDateAndUsername(Datum date, String username);

    void delete(Afspraak afspraak);
}
