class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;

        // dp[i] will store the minimum jumps needed to reach the end from index i
        int[] dp = new int[n];

        // Initialize dp array with -1 meaning "not yet calculated"
        Arrays.fill(dp, -1);

        // Base case: from the last index, 0 jumps are needed (already at the end)
        dp[n-1] = 0;

        for(int i=n-2; i>=0; i--){
            int steps = nums[i]; // Maximum jump length from current index i
            int ans = Integer.MAX_VALUE; // Temporary variable to store minimum jumps from this index

            // Try all possible jump positions from i+1 up to i+steps (but within array bounds)
            for(int j=i+1; j<=i+steps && j<n; j++){
                // Only consider positions from which end is reachable (i.e., dp[j] != -1)
                if(dp[j]!=-1){
                    // Choose the minimum among all reachable positions
                    ans = Math.min(ans, dp[j]+1);
                }
            }
            // If we found any valid jump, store the result in dp[i]
            // Otherwise, leave it as -1 (unreachable)
            dp[i] = ans!=Integer.MAX_VALUE?ans:dp[i];
        }
        // dp[0] gives minimum jumps to reach the end from index 0
        return dp[0]!=-1; // it it has valid steps return true else false
    }
}