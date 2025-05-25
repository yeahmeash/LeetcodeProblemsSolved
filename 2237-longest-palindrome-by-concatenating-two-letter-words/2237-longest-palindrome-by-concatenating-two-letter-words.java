import java.util.*;

class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> count = new HashMap<>();
        int length = 0;
        boolean centerUsed = false;

        for (String word : words) {
            String rev = new StringBuilder(word).reverse().toString();

            if (count.containsKey(rev) && count.get(rev) > 0) {
                // Found a matching pair
                length += 4; // two 2-letter words
                count.put(rev, count.get(rev) - 1);
            } else {
                // Store word for potential pairing
                count.put(word, count.getOrDefault(word, 0) + 1);
            }
        }

        // Check for a palindromic word like "gg", "aa", "bb" that can go in the middle
        for (String word : count.keySet()) {
            if (word.charAt(0) == word.charAt(1) && count.get(word) > 0) {
                length += 2;
                break; // Only one such word can be placed in the middle
            }
        }

        return length;
    }
}
