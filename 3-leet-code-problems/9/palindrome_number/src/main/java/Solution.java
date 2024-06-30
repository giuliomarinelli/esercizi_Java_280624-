public class Solution {

    private static String reversedString(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            stringBuilder.append(str.charAt(i));
        }
        return stringBuilder.toString();
    }

    private static boolean isPalindrome(int x) {
        String xToStr = ((Integer) x).toString();
        String xToStrRev = reversedString(xToStr);
        return xToStr.equals(xToStrRev);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
    }


}
