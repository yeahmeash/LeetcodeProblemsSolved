import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> result = new HashSet<>();

        // Store elements of nums1
        for (int num : nums1) {
            set1.add(num);
        }

        // Check for common elements in nums2
        for (int num : nums2) {
            if (set1.contains(num)) {
                result.add(num);  // Ensures uniqueness
            }
        }

        // Convert result set to int array
        int[] res = new int[result.size()];
        int i = 0;
        for (int num : result) {
            res[i++] = num;
        }

        return res;
    }
}
