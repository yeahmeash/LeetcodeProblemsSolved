class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        
        for (int num : nums) {
            ones = (ones ^ num) & ~twos;  // Update ones
            twos = (twos ^ num) & ~ones;  // Update twos
        }
        
        return ones; // The result will be in ones
    }
}
