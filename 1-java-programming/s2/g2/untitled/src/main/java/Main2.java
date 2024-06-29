import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main2 {

    private static int generateRandomNumber(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }

    private static List<Integer> getSortedRandomNumbers(int n) {

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(generateRandomNumber(0, 100));
        }

        return numbers.stream().sorted().toList();

    }

    private static <T> List<T> getConcatReverseList(List<T> list) {
        List<T> firstList = new ArrayList<>(list);
        List<T> secondList = new ArrayList<>(list).reversed();
        firstList.addAll(secondList);
        return firstList;
    }

    public static void main(String[] args) {

        List<Integer> numberList = getSortedRandomNumbers(10);
        System.out.println(numberList);
        System.out.println(getConcatReverseList(numberList));


    }

}
