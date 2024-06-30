import java.util.ArrayList;
import java.util.List;

public class Solution {

    private static List<List<Integer>> levelOrderTraversal(Integer[] root) {
        if (root.length == 0) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        int elCount = 0;
        int row = 0;
        while (true) {
            int nodesPerRow = (int) Math.pow(2, row);
            int totalNodes = 0;
            for (int i = row; i >= 0; i--) {
                totalNodes += (int) Math.pow(2, i);
            }
            if (totalNodes > root.length) throw new RuntimeException("Bad input");
            List<Integer> level = new ArrayList<>();
            for (int j = 0; j < nodesPerRow; j++) {
                if (root[elCount] != null) level.add(root[elCount]);
                elCount++;
            }
            result.add(level);
            if (totalNodes == root.length) break;
            row++;

        }
        return result;

    }

    public static void main(String[] args) {
        Integer[] root1 = {3, 9, 20, null, null, 15, 7};
        Integer[] root2 = {1};
        Integer[] root3 = {};
        Integer[] root4 = {3, 2, 4, null, null, null, 1, null, null, null, null, null, null, 2, 3};
        System.out.println(levelOrderTraversal(root1));
        System.out.println(levelOrderTraversal(root2));
        System.out.println(levelOrderTraversal(root3));
        System.out.println(levelOrderTraversal(root4));
    }

}
