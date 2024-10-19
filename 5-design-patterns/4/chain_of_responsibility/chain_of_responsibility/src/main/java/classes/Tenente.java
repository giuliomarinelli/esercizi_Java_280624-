package classes;

import enums.FunzioneUfficiale;

public class Tenente extends Ufficiale {


    public Tenente(Ufficiale responsabile, FunzioneUfficiale funzione) {
        super(responsabile, funzione, 1000);
    }
}
