class Solution {
    private int stringLength;
    private String inputString;
    private boolean[][] palindromeTable;
    private List<String> currentPartition = new ArrayList<>();
    private List<List<String>> allPartitions = new ArrayList<>();

    public List<List<String>> partition(String s) {
        stringLength = s.length();
        inputString = s;
        palindromeTable = new boolean[stringLength][stringLength];

        // Initialize the palindrome table with true for all entries
        for (int i = 0; i < stringLength; ++i) {
            Arrays.fill(palindromeTable[i], true);
        }

        // Populate the palindrome table with actual palindrome information
        for (int i = stringLength - 1; i >= 0; --i) {
            for (int j = i + 1; j < stringLength; ++j) {
                palindromeTable[i][j] = (s.charAt(i) == s.charAt(j)) && palindromeTable[i + 1][j - 1];
            }
        }

        // Start the depth-first search from the beginning of the string
        performDfs(0);
        return allPartitions;
    }

    private void performDfs(int startIndex) {
        // If the current start index reaches the end of the string, we've found a complete partition
        if (startIndex == inputString.length()) {
            allPartitions.add(new ArrayList<>(currentPartition));
            return;
        }

        // Explore further partitions starting from the current index
        for (int endIndex = startIndex; endIndex < stringLength; ++endIndex) {
            // If the substring starting at startIndex and ending at endIndex is a palindrome
            if (palindromeTable[startIndex][endIndex]) {
                // Add the palindrome substring to the current partition
                currentPartition.add(inputString.substring(startIndex, endIndex + 1));

                // Continue searching for palindromes from the next index after the current palindrome
                performDfs(endIndex + 1);

                // Backtrack and remove the last added palindrome from the current partition
                currentPartition.remove(currentPartition.size() - 1);
            }
        }
    }
}