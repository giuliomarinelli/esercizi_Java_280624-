import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Singleton {

    private String nomeSistema;
    private String versioneSistema;

    private static Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
            return instance;
        }
        return instance;
    }

    private boolean isValidVersion(String version) {
        String regex = "^\\d+\\.\\d+\\.\\d+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(version);
        return matcher.find();
    }

    private boolean isValidName(String name) {
        String regex = "^[\\w\\s]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        return matcher.find();
    }

    public String getNomeSistema() {
        return nomeSistema;
    }

    public void setNomeSistema(String nomeSistema) throws NameException {
        if (!isValidName(nomeSistema)) throw new NameException("Pattern nome invalido");
        this.nomeSistema = nomeSistema;
    }

    public String getVersioneSistema() {
        return versioneSistema;
    }

    public void setVersioneSistema(String versioneSistema) throws VersioneException {
        if (!isValidVersion(versioneSistema)) throw new VersioneException("Pattern versione invalido");
        this.versioneSistema = versioneSistema;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Singleton singleton = (Singleton) o;
        return Objects.equals(nomeSistema, singleton.nomeSistema) && Objects.equals(versioneSistema, singleton.versioneSistema);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeSistema, versioneSistema);
    }

    @Override
    public String toString() {
        return "Singleton{" +
                "nomeSistema='" + nomeSistema + '\'' +
                ", versioneSistema='" + versioneSistema + '\'' +
                '}';
    }
}
