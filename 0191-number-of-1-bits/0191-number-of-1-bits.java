class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        
        while (n != 0) {
            count += (n & 1);  // Add 1 if the LSB of n is 1
            n >>= 1;  // Right shift n by 1
        }
        
        return count;
    }
}
