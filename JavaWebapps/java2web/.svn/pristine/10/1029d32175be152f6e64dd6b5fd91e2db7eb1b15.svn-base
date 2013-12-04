package be.kdg.urlrewriting.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Mandjes
{
    private Map<String, Mandje> mandjes;

    public Mandjes()
    {
        mandjes = Collections.synchronizedMap(new HashMap<String, Mandje>());
    }

    public void add(String klantNummer, Mandje mandje)
    {
        mandjes.put(klantNummer, mandje);
    }

    public Mandje haalMandje(String klantNummer)
    {
        return mandjes.get(klantNummer);
    }
}
