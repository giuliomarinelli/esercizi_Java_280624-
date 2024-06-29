import rubrica_telefonica.Rubrica;

import java.util.*;

public class Main {

    private static Scanner s = new Scanner(System.in);

    private static int generaNumeroCasuale(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }

    private static List<Integer> generaListaOrdinataDiNumeri(int n) {
        List<Integer> numeriCasuali = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numeriCasuali.add(generaNumeroCasuale(0, 100));
        }
        return numeriCasuali.stream().sorted().toList();
    }

    private static <T> void stampaPosizioniPariODispari(List<T> lista, boolean pari) {
        if (pari) {
            for (int i = 0; i < lista.size(); i = i + 2) {
                System.out.println(lista.get(i));
            }
        } else {
            for (int i = 1; i < lista.size(); i = i + 2) {
                System.out.println(lista.get(i));
            }
        }
    }

    private static <T> List<T> generaListaSpecchio(List<T> listaInput) {
        List<T> reversed = new ArrayList<>(listaInput);
//        reversed = reversed.reversed();
        Collections.reverse(reversed);
        List<T> listaSpecchio = new ArrayList<>(listaInput);
        listaSpecchio.addAll(reversed);

        return listaSpecchio;

    }

    public static void es1() {

        System.out.println("Quante parole vuoi inserire nella collezione?");
        int n = s.nextInt();
        s.nextLine();
        Set<String> paroleAggiunte = new HashSet<>();
        Set<String> paroleDistinte = new HashSet<>();
        Set<String> paroleDuplicate = new HashSet<>();


        for (int i = 0; i < n; i++) {
            System.out.println("Inserisci la parola n. " + (i + 1));
            String parola = s.nextLine();
            boolean parolaDistinta = paroleAggiunte.add(parola);
            if (parolaDistinta) {
                paroleDistinte.add(parola);
            } else {
                paroleDuplicate.add(parola);
                paroleDistinte.remove(parola);
            }
        }

        System.out.println("Parole distinte: " + paroleDistinte);
        System.out.println("Numero parole distinte: " + paroleDistinte.size());
        System.out.println("Parole duplicate: " + paroleDuplicate);


    }

    public static void main(String[] args) {

        List<Integer> lista = generaListaOrdinataDiNumeri(15);

        System.out.println(lista);
        System.out.println(generaListaSpecchio(lista));
        stampaPosizioniPariODispari(lista, true);

        Rubrica rubrica = new Rubrica();
        rubrica.inserisciContatto("Tizio", "222222222");
        rubrica.inserisciContatto("Caio", "23456789");
        rubrica.inserisciContatto("Giorgio", "23456789");
        rubrica.inserisciContatto("Da cancellare", "00000");
        rubrica.stampaListaContatti();
        System.out.println("Cancello l'ultimo contatto");
        rubrica.rimuoviContatto("Da cancellare");
        rubrica.stampaListaContatti();
        System.out.println(rubrica.cercaPersonePerNumero("23456789"));
        System.out.println(rubrica.cercaNumeroPerPersona("Tizio"));

    }

}
