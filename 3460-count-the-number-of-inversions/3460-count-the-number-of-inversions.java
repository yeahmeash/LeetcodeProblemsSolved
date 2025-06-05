import java.util.*;

class Solution {
  public int numberOfPermutations(int n, int[][] requirements) {
    final int MOD = 1_000_000_007;
    final int MAX_INV = n * (n - 1) / 2;
    int[][] dp = new int[n + 1][MAX_INV + 1];
    Map<Integer, Integer> reqMap = new HashMap<>();

    for (int[] req : requirements)
      reqMap.put(req[0] + 1, req[1]); // convert to 1-based

    dp[0][0] = 1;

    for (int i = 1; i <= n; i++) {
      int maxInv = i * (i - 1) / 2;

      // Compute prefix sum of dp[i - 1]
      int[] prefixSum = new int[MAX_INV + 2];
      for (int j = 0; j <= maxInv; j++) {
        prefixSum[j + 1] = (prefixSum[j] + dp[i - 1][j]) % MOD;
      }

      for (int j = 0; j <= maxInv; j++) {
        // dp[i][j] = sum of dp[i - 1][j - k] for k in [0, min(j, i - 1)]
        int low = Math.max(0, j - (i - 1));
        int high = j;
        dp[i][j] = (prefixSum[high + 1] - prefixSum[low] + MOD) % MOD;
      }

      // Apply requirement constraint if needed
      if (reqMap.containsKey(i)) {
        int expected = reqMap.get(i);
        for (int j = 0; j <= maxInv; j++) {
          if (j != expected)
            dp[i][j] = 0;
        }
      }
    }

    int total = 0;
    for (int j = 0; j <= MAX_INV; j++) {
      total = (total + dp[n][j]) % MOD;
    }

    return total;
  }
}

