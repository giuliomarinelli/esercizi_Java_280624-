public class DipendenteFullTime extends Dipendente {

    public DipendenteFullTime(double stipendio, Dipartimento dipartimento) {
        super(stipendio, dipartimento);
    }

    @Override
    public double calculateSalary() {
        return getStipendio();
    }


}
