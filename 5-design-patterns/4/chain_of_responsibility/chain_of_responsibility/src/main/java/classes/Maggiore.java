package classes;

import enums.FunzioneUfficiale;

public class Maggiore extends Ufficiale {


    public Maggiore(Ufficiale responsabile, FunzioneUfficiale funzione) {
        super(responsabile, funzione, 3000);
    }
}
