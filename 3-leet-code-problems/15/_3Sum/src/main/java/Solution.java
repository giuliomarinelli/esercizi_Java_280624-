import java.util.*;
import java.util.stream.Stream;

public class Solution {

    // Restituisce true se la somma algebrica di 3 numeri interi è nulla
    private static boolean isZero(int a, int b, int c) {
        return a + b + c == 0;
    }

    // Dati 3 numeri interi, restituisce true se sono tutti diversi
    private static boolean areDifferent(int a, int b, int c) {
        return a != b && b != c;
    }

    /* Considerando il range a cui possono appartenere gli elementi dell'array nums di input,
    viene fatta una conta di quante volte ciascun numero possibile compare nell'array
    e al contempo viene fatta una conta allo stesso modo di quante volte un numero compare nella tripletta in esame
    se la tripletta in esame vede rappresentato anche solo un numero più volte di quante compare nell'array nums
    di input, allora il metodo restituisce false, vale a dire che la tripletta in esame contiene numeri duplicati e
    pertanto non è valida ed è da scartare.

     */
    private static boolean usesNotDuplicates(int[] nums, List<Integer> tuple) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> tupleCount = new HashMap<>();
        for (int i = -100000; i <= 100000; i++) {
            count.put(i, 0);
            tupleCount.put(i, 0);
        }

        for (int num : nums) {
            int tempCount = count.get(num);
            tempCount++;
            count.put(num, tempCount);
        }

        for (Integer integer : tuple) {
            int tempCount = tupleCount.get(integer);
            tempCount++;
            tupleCount.put(integer, tempCount);
        }


        for (Integer integer : tuple) {
            if (tupleCount.get(integer) > count.get(integer)) return false;
        }
        return true;




    }

    private static Set<List<Integer>> problem(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                for (int k = 0; k < nums.length; k++) {
                    if (isZero(nums[i], nums[j], nums[k])
                            && (areDifferent(i, j, k))) {
                        List<Integer> tuple = Stream.of(nums[i], nums[j], nums[k]).sorted().toList();
                        if (usesNotDuplicates(nums, tuple)) output.add(tuple);
                    }
                }
            }
        }

        return new HashSet<>(output);
    }

    public static void main(String[] args) {
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        int[] nums2 = {0, 1, 1};
        int[] nums3 = {0, 0, 0};
        int[] nums4 = {1, 1, -2, 0, 0, 0};
        System.out.println(problem(nums4));



    }

}
