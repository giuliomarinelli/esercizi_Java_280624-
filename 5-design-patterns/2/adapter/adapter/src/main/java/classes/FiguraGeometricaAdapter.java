package classes;

import interfaces.Figura;
import interfaces.FiguraGeometrica;

public class FiguraGeometricaAdapter implements Figura {

    private final FiguraGeometrica figuraGeometrica;

    public FiguraGeometricaAdapter(FiguraGeometrica figuraGeometrica) {
        this.figuraGeometrica = figuraGeometrica;
    }

    @Override
    public double perimetro() {
        return figuraGeometrica.perimetro();
    }

    @Override
    public double area() {
        return figuraGeometrica.area();
    }

}
