package classes;

import interfaces.Figura;

import java.util.ArrayList;
import java.util.List;

// Accetta tutte le le calssi che implememntano Figura

public class CollezioneFigureGeometriche {

    private final List<Figura> figure = new ArrayList<>();

    public void add(Figura figura) {
        figure.add(figura);
    }

    public void stampaPerimetri() {
        figure.forEach(Figura::perimetro);
    }

    public void stampaAree() {
        figure.forEach(Figura::area);
    }

}
