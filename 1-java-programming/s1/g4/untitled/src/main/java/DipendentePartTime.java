public class DipendentePartTime extends Dipendente {

    private double pagaOraria;

    private int oreMensili;

    public DipendentePartTime(Dipartimento dipartimento, double pagaOraria, int oreMensili) {
        super(stipendio, dipartimento);
        this.pagaOraria = pagaOraria;
        this.oreMensili = oreMensili;
    }

    public double getPagaOraria() {
        return pagaOraria;
    }

    public void setPagaOraria(double pagaOraria) {
        this.pagaOraria = pagaOraria;
    }

    public int getOreMesnili() {
        return oreMensili;
    }

    public void setOreMesnili(int oreMesnili) {
        this.oreMensili = oreMesnili;
    }

    @Override
    public double calculateSalary() {
        return pagaOraria * oreMensili;
    }


}
