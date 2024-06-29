package banca;

public class ContoOnLine extends ContoCorrente {

    private double maxPrelievo;

    public ContoOnLine(String titolare, double saldo, double maxPrelievo) {
        super(titolare, saldo);
        this.maxPrelievo = maxPrelievo;
    }

    public double getMaxPrelievo() {
        return maxPrelievo;
    }

    public void stampaSaldo() {
        System.out.println("Titolare: " + getTitolare());
        System.out.println("Saldo: " + getSaldo());
        System.out.println("Numero movimenti: " + getnMovimenti());
        System.out.println("Massimo movimenti: " + getMaxMovimenti());
        System.out.println("Massimo prelievo: " + maxPrelievo);
    }

    @Override
    public void preleva(double x) throws BancaException {
        if (x > maxPrelievo) throw new BancaException("Il prelievo non è disponibile");
        super.preleva(x);

    }
}
