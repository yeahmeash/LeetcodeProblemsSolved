class Solution {
    public int reverseBits(int n) {
        int result = 0;
        
        for (int i = 0; i < 32; i++) {
            // Extract the last bit of n and shift result left by 1 to make space for the new bit
            result = (result << 1) | (n & 1);
            
            // Shift n to the right to process the next bit
            n >>= 1;
        }
        
        return result;
    }
}
