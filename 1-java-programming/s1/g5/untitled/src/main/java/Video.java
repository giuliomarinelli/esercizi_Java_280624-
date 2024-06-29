public class Video extends ElementoRiproducibile implements GestisceVolume, GestisceLuminosita {

    private int volume;

    private int luminosita;


    public Video(String titolo, int durata, int volume, int luminosita) {
        super(titolo, durata);
        this.volume = volume;
        this.luminosita = luminosita;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setLuminosita(int luminosita) {
        this.luminosita = luminosita;
    }

    @Override
    public void play() {
        for (int i = 0; i < getDurata(); i++) {
            System.out.println(getTitolo() + "!".repeat(volume) + "*".repeat(luminosita));
        }
    }

    @Override
    public void alzaVolume() {
        if (volume < 10) volume++;
    }

    @Override
    public void abbassaVolume() {
        if (volume > 0) volume--;
    }

    @Override
    public void alzaLuminosita() {
        if (luminosita < 10) luminosita++;
    }

    @Override
    public void abbassaLuminosita() {
        if (luminosita > 0) luminosita--;
    }

    @Override
    public void esegui() {
        play();
    }
}
