import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static String reverseWordsInAString(String str) {
        str = str.replaceAll("\\s+", " ").trim();
        String[] strArr = str.split(" ");
        return String.join(" ", Arrays.stream(strArr).toList().reversed());

    }

    public static void main(String[] args) {
        System.out.println(reverseWordsInAString("the sky is blue"));
        System.out.println(reverseWordsInAString("  hello world  "));
        System.out.println(reverseWordsInAString("a good   example"));
    }
}
