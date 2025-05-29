class Solution {
  
    // This method finds the missing number in an array containing numbers from 0 to n
    public int missingNumber(int[] nums) {
      
        // Length of the array should be one number short of the full set
        int n = nums.length;
        // Initialize answer with the last number (which is n since array is 0-indexed)
        int result = n;
      
        // Iterating through the array
        for (int i = 0; i < n; ++i) {
          
            // Apply XOR operation between the current index and the element at that index, and XOR that with the current result
            // Since a number XORed with itself is 0 and a number XORed with 0 is the number itself, this will eventually leave us with only the missing number
            result ^= i ^ nums[i];
        }
      
        // Return the result which is the missing number
        return result;
    }
}