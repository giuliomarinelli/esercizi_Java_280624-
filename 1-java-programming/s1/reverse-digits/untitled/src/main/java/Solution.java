public class Solution {

    private static boolean hasMinusSign(String str) {
        return str.startsWith("-");
    }

    private static String reverseString(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static int reverse(int x) {
        String xToStr = ((Integer) x).toString();
        String prefix = "";
        String absolutePart = "";
        if (hasMinusSign(xToStr)) {
            prefix = "-";
            absolutePart = xToStr.substring(1);
        } else {
            absolutePart = xToStr;
        }
        String reversedXToStr = prefix + reverseString(absolutePart);

        return Integer.parseInt(reversedXToStr);
    }

}
