class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] count = new int[n + 1]; // for prefix sum range counting

        // Mark range counts
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];

            count[l]++;
            if (r + 1 < n) {
                count[r + 1]--;
            }
        }

        // Build actual coverage count using prefix sum
        for (int i = 1; i < n; i++) {
            count[i] += count[i - 1];
        }

        // Check if each element can be reduced to 0
        for (int i = 0; i < n; i++) {
            if (count[i] < nums[i]) {
                return false; // not enough chances to decrement
            }
        }

        return true;
    }
}

