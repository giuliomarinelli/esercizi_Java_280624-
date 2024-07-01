import classes.FiguraGeometricaAdapter;
import classes.Quadrato;
import classes.Rettangolo;
import classes.TriangoloRettangolo;
import interfaces.Figura;
import interfaces.FiguraGeometrica;

public class Main {
    public static void main(String[] args) {
        Figura quadrato = new Quadrato(3);
        System.out.println(quadrato.area());
        System.out.println(quadrato.perimetro());
        Figura triangoloRettangolo = new TriangoloRettangolo(2, 3);
        System.out.println(triangoloRettangolo.area());
        System.out.println(triangoloRettangolo.perimetro());
        // Rettangolo è una FiguraGeometrica. Posso istanziare un rettangolo come FiguraGeometrica
        // grazie a FiguraGeometricaAdapter che implementa Figura
        Figura rettangolo = new FiguraGeometricaAdapter(new Rettangolo(2, 3));
        System.out.println(rettangolo.area());
        System.out.println(rettangolo.perimetro());
    }
}
