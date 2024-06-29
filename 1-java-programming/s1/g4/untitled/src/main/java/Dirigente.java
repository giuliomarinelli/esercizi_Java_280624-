public class Dirigente extends Dipendente {

    public Dirigente(double stipendio, Dipartimento dipartimento) {
        super(stipendio, dipartimento);
    }

    @Override
    public double calculateSalary() {
        return 2000;
    }


}
