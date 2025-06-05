class Solution {
    public boolean isAnagram(String s, String t) {
          // Quick check on string lengths
        if (s.length() != t.length()) return false;

        // Frequency array for 26 lowercase English letters
        int[] counts = new int[26];

        // Count characters in s and t simultaneously
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a']--;
        }

        // If all counts are zero, it's an anagram
        for (int count : counts) {
            if (count != 0) return false;
        }

        return true;
    }

    
}