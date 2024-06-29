import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static double perimetroRettangolo(double l1, double l2) {
        return 2 * (l1 + l2);
    }

    public static int pariODispari(int n) {
        return n % 2;
    }



    public static int moltiplica(int a, int b) {
        return a * b;
    }

    public static String concatena(String a, int b) {
        return a + b;
    }

    public static String[] inserisciInArray(String[] arrInput, String str) {
        String[] newArr = new String[6];
        for (int i = 0; i < arrInput.length; i++) {
            if (i < 2) {
                newArr[i] = arrInput[i];
            } else if (i == 2) {
                newArr[i] = str;
            } else {
                newArr[i] = arrInput[i - 1];
            }
        }
        return newArr;

    }

    public static void main1() {
        int a = 10, b = 20;
        System.out.println(moltiplica(a, b));
        String str = "Hello";
        int c = 10;
        System.out.println(concatena(str, c));
        String[] arrStr = {"LUN", "MAR", "GIO", "VEN", "SAB"};
        String str2 = "MER";
        String[] newArr = inserisciInArray(arrStr, str2);
        for (String s : newArr) {
            System.out.println(s);
        }
    }

    public static void main2() {
        Scanner s = new Scanner(System.in);
        String[] _3Stringhe = new String[3];
        StringBuilder concat = new StringBuilder();
        for (int i = 0; i < _3Stringhe.length; i ++) {
            System.out.println("Inserisci stringa " + (i + 1));
            _3Stringhe[i] = s.nextLine();
            concat.append(_3Stringhe[i]);
        }

        System.out.println(concat.toString());

        StringBuilder concat1 = new StringBuilder();
        for (int i = _3Stringhe.length - 1; i >= 0; i --) {
            System.out.println("Inserisci stringa " + (i + 1));
            s.nextLine();
            concat1.append(_3Stringhe[i]);
        }

        System.out.println(concat1.toString());

    }

    public static void main(String[] args) {
//        main1();
        main2();

    }



}
