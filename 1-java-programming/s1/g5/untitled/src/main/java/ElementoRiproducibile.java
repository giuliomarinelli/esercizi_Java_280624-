public abstract class ElementoRiproducibile extends ElementoMultimediale {

    private int durata;

    public abstract void play();

    public ElementoRiproducibile(String titolo, int durata) {
        super(titolo);
        this.durata = durata;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

}
