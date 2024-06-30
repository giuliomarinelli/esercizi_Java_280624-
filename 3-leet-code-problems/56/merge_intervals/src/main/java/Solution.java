import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {

    private static boolean overlap(Integer[] int1, Integer[] int2) {
        return int1[1] >= int2[0];
    }

    private static Integer[] mergeTwoIntervals(Integer[] int1, Integer[] int2) {
        return new Integer[]{int1[0], int2[1]};
    }

    private static String arrToString(Integer[] arr) {
        return Arrays.stream(arr).map(n -> ((Integer) n).toString())
                .collect(Collectors.joining(", ", "[", "]"));
    }



    public static void main(String[] args) {
        Integer[][] intervals = {{1, 3}, {2, 6}};
        System.out.println(overlap(intervals[0], intervals[1]));
        System.out.println(arrToString(mergeTwoIntervals(intervals[0], intervals[1])));
    }
}
