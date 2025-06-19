class Solution {
    // Method to calculate the length of the longest substring without repeating characters
    public int lengthOfLongestSubstring(String s) {
        // Use a HashSet to store the characters in the current window without duplicates
        Set<Character> charSet = new HashSet<>();
        int leftPointer = 0; // Initialize the left pointer for the sliding window
        int maxLength = 0; // Variable to keep track of the longest substring length

        // Iterate through the string with the right pointer
        for (int rightPointer = 0; rightPointer < s.length(); ++rightPointer) {
            char currentChar = s.charAt(rightPointer); // Current character at the right pointer

            // If currentChar is already in the set, it means we have found a repeating character
            // We slide the left pointer of the window to the right until the duplicate is removed
            while (charSet.contains(currentChar)) {
                charSet.remove(s.charAt(leftPointer++));
            }

            // Add the current character to the set as it is now unique in the current window
            charSet.add(currentChar);

            // Calculate the length of the current window (rightPointer - leftPointer + 1)
            // Update the maxLength if the current window is larger
            maxLength = Math.max(maxLength, rightPointer - leftPointer + 1);
        }

        // Return the length of the longest substring without repeating characters
        return maxLength;
    }
}
