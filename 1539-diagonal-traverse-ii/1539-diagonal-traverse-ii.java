import java.util.*;

class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> diagonalMap = new HashMap<>();
        int total = 0;

        // Group elements by (i + j)
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                diagonalMap.computeIfAbsent(i + j, k -> new ArrayList<>()).add(nums.get(i).get(j));
                total++;
            }
        }

        List<Integer> result = new ArrayList<>(total);

        // Collect elements from diagonals
        for (int key = 0; key <= diagonalMap.size(); key++) {
            List<Integer> list = diagonalMap.get(key);
            if (list != null) {
                // reverse order for diagonal pattern
                for (int i = list.size() - 1; i >= 0; i--) {
                    result.add(list.get(i));
                }
            }
        }

        // Convert to array
        int[] resArr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resArr[i] = result.get(i);
        }

        return resArr;
    }
}
