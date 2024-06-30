public class Solution {

    public static boolean wordBreak(String s, String[] wordDict) {

        for (String word : wordDict) {
            s = s.replaceAll(word, "");
        }

        return s.isEmpty();
    }


    public static void main(String[] args) {

        String s1 = "leetcode";
        String[] wordDict1 = {"leet", "code"};
        System.out.println(wordBreak(s1, wordDict1));

        String s2 = "applepenapple";
        String[] wordDict2 = {"apple", "pen"};
        System.out.println(wordBreak(s2, wordDict2));

        String s3 = "catsandog";
        String[] wordDict3 = {"cats", "dog", "sand", "and", "cat"};
        System.out.println(wordBreak(s3, wordDict3));

    }

}
