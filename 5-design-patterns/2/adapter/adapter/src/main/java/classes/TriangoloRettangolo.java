package classes;

import interfaces.Figura;

public class TriangoloRettangolo implements Figura {

    private final double base;
    private final double altezza;
    private final double ipotenusa;

    public TriangoloRettangolo(double base, double altezza) {
        this.base = base;
        this.altezza = altezza;
        ipotenusa = Math.sqrt(Math.pow(base, 2) + Math.pow(altezza, 2));
    }

    @Override
    public double perimetro() {
        return base + altezza + ipotenusa;
    }

    @Override
    public double area() {
        return (base * altezza) / 2;
    }

    public double getBase() {
        return base;
    }

    public double getAltezza() {
        return altezza;
    }

    public double getIpotenusa() {
        return ipotenusa;
    }
}
