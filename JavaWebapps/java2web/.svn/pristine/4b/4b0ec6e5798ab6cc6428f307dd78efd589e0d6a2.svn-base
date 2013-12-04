package be.kdg.lievelingsgerechtmodel;

import java.util.Map;
import java.util.HashMap;

public class Lievelingsgerechten
{
    private static Lievelingsgerechten deLievelingsgerechten = null;
    private Map<String, String> lievelingsgerechten;

    public static Lievelingsgerechten getInstance()
    {
        if (deLievelingsgerechten == null)
        {
            deLievelingsgerechten = new Lievelingsgerechten();
        }
        return deLievelingsgerechten;
    }

    private Lievelingsgerechten()
    {
        this.lievelingsgerechten = new HashMap<String, String>();
        init();
    }

    private void init()
    {
        lievelingsgerechten.put("wouter", "frieten");
        lievelingsgerechten.put("gij", "spaghetti");
    }

    public String getLievelingsgerecht(String naam)
    {
        String gerecht = lievelingsgerechten.get(naam);
        if (gerecht == null)
        {
            return "";
        }
        return gerecht;
    }

    public void veranderLievelingsgerecht(String naam, String gerecht)
    {
        lievelingsgerechten.put(naam, gerecht);
    }
}
