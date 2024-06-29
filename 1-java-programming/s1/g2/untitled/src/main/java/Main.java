import java.util.Scanner;

public class Main {

    public static boolean stringaPariDispari(String str) {
        return str.length() % 2 == 0;
    }

    public static boolean annoBisestile(int anno) {
        return (anno % 4 == 0 && anno % 100 != 0) ^ (anno % 4 == 0 && anno % 100 == 0 && anno % 400 == 0);
    }

    public static void es1() {
        System.out.println(stringaPariDispari("Ciao"));
        System.out.println(stringaPariDispari("Ciaoone"));
        System.out.println(annoBisestile(2000));
        System.out.println(annoBisestile(2004));
        System.out.println(annoBisestile(1000));
    }

    public static void es2() {
        Scanner s = new Scanner(System.in);
        System.out.println("Inserisci un intero");
        int n = s.nextInt();
        switch (n) {
            case 0 -> System.out.println("ZERO");
            case 1 -> System.out.println("UNO");
            case 2 -> System.out.println("DUE");
            case 3 -> System.out.println("TRE");
            default -> System.out.println("ERRORE!!!");
        }
    }

    public static void es3() {


        while (true) {
            Scanner s = new Scanner(System.in);
            System.out.println("Inserisci un stringa");
            String str = s.nextLine();
            if (str.equals(":q")) return;
            StringBuilder strBuilder = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (i < str.length() - 1) {
                    strBuilder.append(str.charAt(i)).append(",");
                } else {
                    strBuilder.append(str.charAt(i));
                }
            }

            System.out.println(strBuilder.toString());

        }

    }

    public static void es4() {
        Scanner s = new Scanner(System.in);
        System.out.println("Inserisci un numero intero positivo");
        int input = s.nextInt();
        for (int i = input; i >= 0; i--) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        es4();
    }

}

