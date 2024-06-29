public class RegistrazioneAudio extends ElementoRiproducibile implements GestisceVolume{

    private int volume; // 0 - 10

    public RegistrazioneAudio(String titolo, int durata, int volume) {
        super(titolo, durata);
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    @Override
    public void play() {
        for (int i = 0; i < getDurata(); i++) {
            System.out.println(getTitolo() + "!".repeat(volume));
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
    public void esegui() {
        play();
    }
}
