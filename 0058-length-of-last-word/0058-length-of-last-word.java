class Solution {
    public int lengthOfLastWord(String s) {
        // Trim any trailing spaces
        s = s.trim();
        
        // Initialize a variable to count the length of the last word
        int length = 0;
        
        // Traverse the string from the end to the start
        for (int i = s.length() - 1; i >= 0; i--) {
            // If we encounter a space, stop counting
            if (s.charAt(i) == ' ') {
                break;
            }
            // Otherwise, increment the length
            length++;
        }
        
        return length;
    }
}
