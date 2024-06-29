import banca.CustomUnCheckedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

    private static void lanciaUnCheckedException() {
        throw new CustomUnCheckedException("Prova");
    }

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    private static String intArrayToString(int[] arr) {
        return Arrays.stream(arr).mapToObj(Integer::toString)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    private static void program1() {

        Scanner s = new Scanner(System.in);

        int[] numbers = new int[5];

        int min = 1, max = 10;

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new Random().nextInt(max - min + 1) + min;
        }

        System.out.println("Array iniziale:" + intArrayToString(numbers));

        while (true) {
            System.out.println("\nScegli quale posizione dell'array sostituire: 1, 2, 3, 4, 5. Inserisci 0 " +
                    "per terminare il programma.");
            int ind = s.nextInt();
            if (ind == 0) return;
            ind--;
            try {
                System.out.println("Che numero intero vuoi inserire in posizione "
                        + (ind + 1) + "al posto di " + numbers[ind] + "?");
            } catch (ArrayIndexOutOfBoundsException e) {
                logger.error("ERRORE! Devi scegliere una posizione tra 1, 2, 3, 4 o 5, hai scelto " + ind);
                System.out.println("ERRORE! Devi scegliere una posizione tra 1, 2, 3, 4 o 5, hai scelto " + ind);
                System.out.println("\nRicominciamo!");
                continue;
            }
            int newInt = s.nextInt();


            numbers[ind] = newInt;
            System.out.println("Ecco l'array modificato con il numero " + newInt
                    + "inserito in posizione n. " + (ind + 1) + ":\n" + intArrayToString(numbers));

        }

    }

    private static void program2() {
        Scanner s = new Scanner(System.in);
        System.out.println("Calcoliamo i consumi (Indica eventuali decimali utilizzando il" +
                " simbolo virgola \",\". Non usare il punto)");
        System.out.println("Quanti km hai percorso?");
        int km = s.nextInt();
        System.out.println("Quanti litri di carburante hai consumato?");
        int l = s.nextInt();
        try {
            System.out.println("Il consumo medio è " + (km / l) + "km/L");
        } catch (ArithmeticException e) {
            if (l == 0) logger.error("ERRORE => Impossibile dividere per zero");
        }
    }

    public static void main(String[] args) {



    }

}
