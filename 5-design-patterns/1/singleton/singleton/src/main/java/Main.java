public class Main {

    // SINGLETON = Pattern creazionale, come prototype che fornisce ogni volta la copia di un oggetto prototipo
    // Prototype estensivamente usato in JavaScript/TypeScript

    public static void main(String[] args) throws NameException, VersioneException {
        Singleton system = Singleton.getInstance();
        system.setNomeSistema("Windows98");
        system.setVersioneSistema("1.0.0");
        System.out.println(system);
        System.out.println(system.hashCode());
        System.out.println();
        Singleton system1 = Singleton.getInstance();
        System.out.println(system1);
        System.out.println(system1.hashCode());
        system.setVersioneSistema("1.0.1");
        System.out.println(system);
        System.out.println(system1);

    }

}
