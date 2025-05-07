class Solution {
    public boolean isPalindrome(int x) {
        // Step 1: Handle negative numbers and numbers ending with 0 (but not 0 itself)
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        // Step 2: Reverse the second half of the number
        int reversedHalf = 0;
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        // Step 3: Check if the first half equals the reversed second half
        // x == reversedHalf when the length of the number is even
        // x == reversedHalf / 10 when the length of the number is odd (e.g., for 121, 12 == 12)
        return x == reversedHalf || x == reversedHalf / 10;
    }
}
