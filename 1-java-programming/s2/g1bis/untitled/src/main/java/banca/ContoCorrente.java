package banca;

public class ContoCorrente {

    private String titolare;
    private int nMovimenti;
    private final int maxMovimenti = 50;
    private double saldo;

    public ContoCorrente(String titolare, double saldo) {
        this.saldo = saldo;
        this.titolare = titolare;
    }

    public String getTitolare() {
        return titolare;
    }

    public int getnMovimenti() {
        return nMovimenti;
    }

    public int getMaxMovimenti() {
        return maxMovimenti;
    }

    public double getSaldo() {
        return saldo;
    }

    public void preleva(double x) throws BancaException {
        if (x - saldo < 0) {
            nMovimenti++;
            throw new BancaException("Il conto è in rosso");
        }
        if (nMovimenti < maxMovimenti)
            saldo -= x;
        else
            saldo -= x + 0.5;
        nMovimenti++;
    }



}
