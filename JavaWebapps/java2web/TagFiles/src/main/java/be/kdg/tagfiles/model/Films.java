package be.kdg.tagfiles.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Films
{
    private List<String> films;

    public Films()
    {
        List<String> filmLijst = new ArrayList<String>();
        filmLijst.add("Memento");
        filmLijst.add("The Matrix");
        filmLijst.add("La double vie de Veronique");
        filmLijst.add("Todo sobre mi madre");
        this.films = Collections.unmodifiableList(filmLijst);
    }

    public List<String> getFilms()
    {
        return films;
    }
}
