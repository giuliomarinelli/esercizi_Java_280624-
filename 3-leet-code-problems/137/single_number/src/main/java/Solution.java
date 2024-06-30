import java.util.Arrays;

public class Solution {

    private static int singleNumber(int[] nums) {
        int singleNumber = 0;
        int[] sortedNums = Arrays.stream(nums).sorted().toArray();
        for (int i = 0; i < sortedNums.length; i++) {
            if (i < sortedNums.length - 1 && sortedNums[i] != sortedNums[i + 1]) singleNumber = sortedNums[i];
            else if (i == sortedNums.length - 1 && sortedNums[i] != sortedNums[i - 1]) singleNumber = sortedNums[i];
        }
        return singleNumber;
    }

    // Bisogna gestire il caso in cui single number è 0 oppure fare un controllo sul pattern dell'input

    public static void main(String[] args) {
        int[] nums1 = {2, 2, 3, 2};
        int[] nums2 = {0, 1, 0, 1, 0, 1, 99};
        System.out.println(singleNumber(nums1));
        System.out.println(singleNumber(nums2));
    }
}
