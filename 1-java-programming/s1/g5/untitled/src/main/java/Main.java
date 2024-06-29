import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        ElementoMultimediale[] elementiMultimediali = new ElementoMultimediale[5];

        for (int i = 0; i < 5; i++) {

            System.out.println("Aggiunta elemento multimedial n. " + (i + 1) + "\n");

            System.out.println("Digita 1 per aggiungere VIDEO, 2 per AUDIO, 3 per IMMAGINE");

            int scelta = s.nextInt();

            s.nextLine();

            switch (scelta) {
                case 1 -> {
                    System.out.println("VIDEO");
                    System.out.println("Inserisci titolo");
                    String titolo = s.nextLine();
                    System.out.println("Inserisci durata");
                    int durata = s.nextInt();
                    System.out.println("Inserisci volume iniziale (0 - 10)");
                    int volume = s.nextInt();
                    System.out.println("Inserisci luminosità iniziale (0 - 10)");
                    int luminosita = s.nextInt();
                    elementiMultimediali[i] = new Video(titolo, durata, volume, luminosita);
                    System.out.println("Video \"" + titolo + "\" aggiunto correttamente.\n");
                }
                case 2 -> {
                    System.out.println("AUDIO");
                    System.out.println("Inserisci titolo");
                    String titolo = s.nextLine();
                    System.out.println("Inserisci durata");
                    int durata = s.nextInt();
                    System.out.println("Inserisci volume iniziale (0 - 10)");
                    int volume = s.nextInt();
                    elementiMultimediali[i] = new RegistrazioneAudio(titolo, durata, volume);
                    System.out.println("Audio \"" + titolo + "\" aggiunto correttamente.\n");
                }
                case 3 -> {
                    System.out.println("IMMAGINE");
                    System.out.println("Inserisci titolo");
                    String titolo = s.nextLine();
                    System.out.println("Inserisci luminosità iniziale (0 - 10)");
                    int luminosita = s.nextInt();
                    elementiMultimediali[i] = new Immagine(titolo, luminosita);
                    System.out.println("Immagine \"" + titolo + "\" aggiunta correttamente.\n");
                }
                default -> {
                    System.out.println("ERRORE");
                    return;
                }
            }



        }

        while (true) {
            System.out.println("Scegli 1, 2, 3, 4, o 5 per eseguire il corrispondente elemento multimediale, 0 per terminare il programma");
            int scelta = s.nextInt();
            if (scelta == 0) {
                System.out.println("\nProgramma terminato");
                return;
            }
            elementiMultimediali[scelta - 1].esegui();
        }

    }

}
