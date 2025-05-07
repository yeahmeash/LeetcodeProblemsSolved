class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1; // If there's only 1 step, there's only 1 way to reach the top
        
        int prev1 = 1, prev2 = 1;  // Initial base cases: ways(0) = 1, ways(1) = 1
        int current = 0;
        
        for (int i = 2; i <= n; i++) {
            current = prev1 + prev2;  // Current number of ways = ways(n-1) + ways(n-2)
            prev2 = prev1;  // Move prev1 to prev2
            prev1 = current;  // Move current to prev1
        }
        
        return current;  // Return the number of ways to reach step n
    }
}
