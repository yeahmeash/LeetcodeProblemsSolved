class Solution {
    // Parent array representing the disjoint set (union-find structure)
    private int[] parent;

    /**
     * Generates the smallest equivalent string based on mapping rules.
     * 
     * @param s1      - first input string with mapping rules
     * @param s2      - second input string with mapping rules
     * @param baseStr - the base string to be transformed
     * @return The smallest lexicographical string after applying the rules from s1 and s2
     */
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        // Initialize the parent array for 26 characters
        parent = new int[26];
        for (int i = 0; i < 26; ++i) {
            parent[i] = i;
        }
      
        // Process the mappings in s1 and s2
        for (int i = 0; i < s1.length(); ++i) {
            // Convert the characters to zero-based indices
            int indexS1 = s1.charAt(i) - 'a';
            int indexS2 = s2.charAt(i) - 'a';
          
            // Find the parents for both indices
            int parentS1 = find(indexS1);
            int parentS2 = find(indexS2);
          
            // Union the parents by rank
            if (parentS1 < parentS2) {
                parent[parentS2] = parentS1;
            } else {
                parent[parentS1] = parentS2;
            }
        }

        // Build the result string based on baseStr and union-find structure
        StringBuilder result = new StringBuilder();
        for (char ch : baseStr.toCharArray()) {
            // Translate the base characters according to the smallest parent character
            char smallestEquivalentChar = (char) (find(ch - 'a') + 'a');
            result.append(smallestEquivalentChar);
        }
        return result.toString();
    }

    /**
     * Finds the representative of the set that element x is part of.
     * 
     * @param x - an element for which to find the set representative
     * @return The parent or the representative of the set
     */
    private int find(int x) {
        // Path compression: Update the parent along the search path
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}