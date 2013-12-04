package be.kdg.agenda.model.afspraken;

import java.util.Set;

public interface AfspraakDAO
{

    void create(Afspraak afspraak);

    void update(Afspraak afspraak);

    Afspraak retrieve(int id);

    Set<Afspraak> retrieveByDateAndUsername(Datum date, String username);

    void delete(Afspraak afspraak);
}
