package classes;

import enums.FunzioneUfficiale;

public class Capitano extends Ufficiale {


    public Capitano(Ufficiale responsabile, FunzioneUfficiale funzione) {
        super(responsabile, funzione, 2000);
    }
}
