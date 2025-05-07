class Solution {
    public int[] plusOne(int[] digits) {
        // Start from the last digit and move backwards
        for (int i = digits.length - 1; i >= 0; i--) {
            // If the current digit is less than 9, we can just add 1 to it
            if (digits[i] < 9) {
                digits[i]++;  // Increment the digit
                return digits;  // Return the result as no carry is required
            }
            // If the current digit is 9, set it to 0 and carry over 1
            digits[i] = 0;
        }
        
        // If we have gone through all digits and they are all 9's, we need to add a new digit at the front
        int[] result = new int[digits.length + 1];
        result[0] = 1;  // Set the first element to 1
        return result;  // The rest of the array is already filled with 0's
    }
}
