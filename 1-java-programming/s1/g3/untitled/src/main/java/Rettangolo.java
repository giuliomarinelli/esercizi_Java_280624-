public class Rettangolo {

    private double l1;
    private double l2;

    public Rettangolo(double l1, double l2) {
        this.l1 = l1;
        this.l2 = l2;
    }

    public double calcolaPerimetro() {
        return (l1 + l2) * 2;
    }

    public double calcolaArea() {
        return l1 * l2;
    }

    public void stampaRettangolo() {
        System.out.println("Area = " + calcolaArea());
        System.out.println("Perimmetro = " + calcolaPerimetro());
    }

    public static void stampaDueRettangoli(Rettangolo r1, Rettangolo r2) {
        System.out.println("Rettangolo 1");
        r1.stampaRettangolo();
        System.out.println("Rettangolo 2");
        r2.stampaRettangolo();
        System.out.println("Somma aree");
        System.out.println(r1.calcolaArea() + r2.calcolaArea());
        System.out.println("Somma perimeri");
        System.out.println(r1.calcolaPerimetro() + r2.calcolaPerimetro());

    }


}
