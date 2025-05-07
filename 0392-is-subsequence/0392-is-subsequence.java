class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0; // Pointer for string s
        int j = 0; // Pointer for string t
        
        // Traverse through both strings
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++; // Move pointer i when characters match
            }
            j++; // Always move pointer j
        }
        
        // If i reaches the end of s, it means all characters of s are matched in order in t
        return i == s.length();
    }
}
