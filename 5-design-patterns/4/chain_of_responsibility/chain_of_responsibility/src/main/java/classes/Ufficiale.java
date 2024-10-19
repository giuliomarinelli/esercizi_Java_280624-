package classes;

import enums.FunzioneUfficiale;

public abstract class Ufficiale {

    private Ufficiale responsabile;
    private FunzioneUfficiale funzione;
    private double stipendio;

    public Ufficiale(Ufficiale responsabile, FunzioneUfficiale funzione, double stipendio) {
        this.responsabile = responsabile;
        this.funzione = funzione;
        this.stipendio = stipendio;
    }

    public Ufficiale getResponsabile() {
        return responsabile;
    }

    public FunzioneUfficiale getFunzione() {
        return funzione;
    }

    public double getStipendio() {
        return stipendio;
    }
}
