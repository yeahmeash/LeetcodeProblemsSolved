import java.util.*;

class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int MOD = 1_000_000_007;

        // Step 1: Make a sorted copy of nums1 for binary search
        int[] sorted = Arrays.copyOf(nums1, n);
        Arrays.sort(sorted);

        long totalDiff = 0;
        int maxGain = 0;

        // Step 2: Try replacing each element in nums1
        for (int i = 0; i < n; i++) {
            int a = nums1[i];
            int b = nums2[i];

            int currentDiff = Math.abs(a - b);
            totalDiff += currentDiff;

            // Step 3: Find closest value to b in sorted[]
            int idx = binarySearchClosest(sorted, b);
            if (idx < n) {
                int newDiff = Math.abs(sorted[idx] - b);
                maxGain = Math.max(maxGain, currentDiff - newDiff);
            }
            if (idx > 0) {
                int newDiff = Math.abs(sorted[idx - 1] - b);
                maxGain = Math.max(maxGain, currentDiff - newDiff);
            }
        }

        return (int)((totalDiff - maxGain + MOD) % MOD);
    }

    private int binarySearchClosest(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
