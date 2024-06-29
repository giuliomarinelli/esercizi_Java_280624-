import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Random;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void program1() {

        int[] numbers = new int[5];

        int min = 1, max = 10;

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new Random().nextInt(max - min + 1) + min;
        }

        Arrays.stream(numbers).forEach(System.out::println);

    }

    public static void main(String[] args) {

        program1();

    }

}
