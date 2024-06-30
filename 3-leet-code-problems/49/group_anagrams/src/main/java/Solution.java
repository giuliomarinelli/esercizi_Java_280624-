import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    private static String sortString(String str) {
        return Arrays.stream(str.split("")).sorted().collect(Collectors.joining(""));
    }

    private static boolean areAanagrams(String str1, String str2) {
        return sortString(str1).equals(sortString(str2));
    }

    private static List<List<String>> groupAnagrams(String[] strs) {

        Set<String> reversedStrs = new HashSet<>();
        for (String str : strs) {
            reversedStrs.add(sortString(str));
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String key : reversedStrs) {
            map.put(key, new ArrayList<>());
        }
        for (String str : strs) {
            List<String> group = map.get(sortString(str));
            group.add(str);
            map.put(sortString(str), group);
        }

        Set<String> keys = map.keySet();

        List<List<String>> result = new ArrayList<>();

        for (String key : keys) {
            List<String> group = map.get(key);
            if (!group.isEmpty()) result.add(group);
        }

        return result;
    }

    public static void main(String[] args) {

        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
        System.out.println(groupAnagrams(new String[]{""}));
        System.out.println(groupAnagrams(new String[]{"a"}));
        System.out.println(groupAnagrams(new String[]{"ciao", "oaic", "asinel", "saline", "bau", "roma", "amor", "mora"}));

    }
}
