import java.util.UUID;

public abstract class Dipendente {

    private final UUID matricola;

    private double stipendio;

    private Dipartimento dipartimento;

    public Dipendente(double stipendio, Dipartimento dipartimento) {
        this.stipendio = stipendio;
        this.dipartimento = dipartimento;
        matricola = UUID.randomUUID();
    }

    public abstract double calculateSalary();

    public UUID getMatricola() {
        return matricola;
    }

    public double getStipendio() {
        return stipendio;
    }

    public Dipartimento getDipartimento() {
        return dipartimento;
    }

    public void setDipartimento(Dipartimento dipartimento) {
        this.dipartimento = dipartimento;
    }
}
