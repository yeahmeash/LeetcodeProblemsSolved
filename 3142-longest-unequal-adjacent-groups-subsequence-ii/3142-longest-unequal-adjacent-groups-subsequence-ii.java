class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
    int n = words.length;
    int[] longestSubsequenceLength = new int[n];
    int[] previousIndex = new int[n];
    Arrays.fill(longestSubsequenceLength, 1);
    Arrays.fill(previousIndex, -1);
    int maxLength = 1;

    // Dynamic programming to find the longest subsequence
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < i; ++j) {
            // Check if alternating groups and if it's beneficial to extend the sequence from j to i
            if (groups[i] != groups[j] && longestSubsequenceLength[i] < longestSubsequenceLength[j] + 1 && canTransform(words[i], words[j])) {
                longestSubsequenceLength[i] = longestSubsequenceLength[j] + 1;
                previousIndex[i] = j;
                maxLength = Math.max(maxLength, longestSubsequenceLength[i]);
            }
        }
    }

    // Constructing the longest subsequence from the dynamic programming table
    List<String> result = new ArrayList<>();
    for (int i = 0; i < n; ++i) {
        if (longestSubsequenceLength[i] == maxLength) {
            for (int j = i; j >= 0; j = previousIndex[j]) {
                result.add(words[j]);
            }
            break;
        }
    }

    // The sequence is constructed in reverse so we need to reverse it to get the correct order
    Collections.reverse(result);
    return result;
}
private static boolean canTransform(String firstWord, String secondWord) {
    if (firstWord.length() != secondWord.length()) {
        return false;
    }
    int diffCount = 0;
    for (int i = 0; i < firstWord.length(); ++i) {
        if (firstWord.charAt(i) != secondWord.charAt(i)) {
            diffCount++;
        }
    }
    return diffCount == 1;
}

}