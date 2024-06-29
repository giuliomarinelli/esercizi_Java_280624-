public class Immagine extends ElementoMultimediale implements GestisceLuminosita, MostraImmagine {

    private int luminosita;

    public Immagine(String titolo, int luminosita) {
        super(titolo);
        this.luminosita = luminosita;
    }

    @Override
    public void esegui() {
        show();
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
    public void show() {
        System.out.println(getTitolo() + "*".repeat(luminosita));
    }
}
