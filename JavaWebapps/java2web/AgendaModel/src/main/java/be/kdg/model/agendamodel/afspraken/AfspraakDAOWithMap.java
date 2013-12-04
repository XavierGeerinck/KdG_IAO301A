package be.kdg.model.agendamodel.afspraken;

import java.util.*;

public class AfspraakDAOWithMap implements AfspraakDAO
{

    private final Map<Integer, Afspraak> afspraaks;
    private static int nextId = 0;

    public AfspraakDAOWithMap()
    {
        this.afspraaks = Collections.synchronizedMap(new HashMap<Integer, Afspraak>());
        initData();
    }

    private void initData()
    {
        Afspraak afspraak = new Afspraak("bla", new Datum(), new Tijdstip(10, 15), new Tijdstip(12, 15), "Les webapplicaties");
        create(afspraak);
        afspraak = new Afspraak("bla", new Datum(), new Tijdstip(13, 15), new Tijdstip(15, 15), "Les webapplicaties");
        create(afspraak);
        afspraak = new Afspraak("bla", new Datum(), new Tijdstip(8, 0), new Tijdstip(10, 0), "Les databanken");
        create(afspraak);
    }

    public void create(Afspraak afspraak)
    {
        if (afspraak.getId() != -1)
        {
            return;
        }
        synchronized (this)
        {
            afspraak.setId(nextId++);
        }
        afspraaks.put(afspraak.getId(), new Afspraak(afspraak));
    }

    public void update(Afspraak afspraak)
    {
        if (afspraak.getId() == -1)
        {
            return;
        }
        afspraaks.put(afspraak.getId(), new Afspraak(afspraak));
    }

    public Afspraak retrieve(int id)
    {
        Afspraak afspraak = afspraaks.get(id);
        if (afspraak == null)
        {
            return null;
        }
        return new Afspraak(afspraak);
    }

    public Set<Afspraak> retrieveByDateAndUsername(Datum date, String username)
    {
        Set<Afspraak> result = new HashSet<Afspraak>();
        synchronized (afspraaks)
        {
            for (Afspraak afspraak : afspraaks.values())
            {
                if (afspraak.getDate().equals(date) && afspraak.getUsername().equals(username))
                {
                    result.add(new Afspraak(afspraak));
                }
            }
        }
        return result;
    }

    public void delete(Afspraak afspraak)
    {
        afspraaks.remove(afspraak.getId());
    }
}
