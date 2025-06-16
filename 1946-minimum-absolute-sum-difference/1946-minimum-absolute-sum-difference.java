import java.util.*;

class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int MOD = 1_000_000_007;
        int n = nums1.length;
        TreeSet<Integer> sorted = new TreeSet<>();
        
        for (int num : nums1) sorted.add(num);

        long totalDiff = 0;
        int maxGain = 0;

        for (int i = 0; i < n; i++) {
            int a = nums1[i], b = nums2[i];
            int currentDiff = Math.abs(a - b);
            totalDiff = (totalDiff + currentDiff) % MOD;

            // Use TreeSet to find the closest element to b in nums1
            Integer ceil = sorted.ceiling(b);
            Integer floor = sorted.floor(b);

            if (ceil != null) {
                maxGain = Math.max(maxGain, currentDiff - Math.abs(ceil - b));
            }
            if (floor != null) {
                maxGain = Math.max(maxGain, currentDiff - Math.abs(floor - b));
            }
        }

        return (int)((totalDiff - maxGain + MOD) % MOD);
    }
}

