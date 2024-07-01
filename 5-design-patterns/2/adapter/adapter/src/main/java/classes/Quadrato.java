package classes;

import interfaces.Figura;

public class Quadrato implements Figura {

    private double lato;

    public Quadrato() {}

    public Quadrato(double lato) {
        this.lato = lato;
    }

    @Override
    public double perimetro() {
        return 4 * lato;
    }

    @Override
    public double area() {
        return Math.pow(lato, 2);
    }
}
