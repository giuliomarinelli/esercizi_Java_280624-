import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.println("Quante parole vuoi inserire?");

        int n = s.nextInt();
        s.nextLine();

        Set<String> parole = new HashSet<>();
        int numeroParoleDistinte = 0;
        Set<String> paroleDuplicate = new HashSet<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Inserisci la parola n. " + (i + 1));
            String parola = s.nextLine();
            boolean parolaNuova = parole.add(parola);
            if (parolaNuova) {
                numeroParoleDistinte++;
            } else {
                paroleDuplicate.add(parola);
            }
        }

        System.out.println("Parole duplicate: " + String.join(", ", paroleDuplicate));
        System.out.println();
        System.out.println("Numero di parole distinte: " + numeroParoleDistinte);
        System.out.println("Parole distinte: " + String.join(", ", parole));

    }

}
