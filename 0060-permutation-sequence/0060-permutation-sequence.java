class Solution {
    public String getPermutation(int n, int k) {
        // StringBuilder to create the resulting permutation string
        StringBuilder permutation = new StringBuilder();
        // Visited array keeps track of which numbers have been used
        boolean[] visited = new boolean[n + 1];
      
        // Loop through each position in the permutation
        for (int i = 0; i < n; ++i) {
            // Calculate the factorial of the numbers left
            int factorial = 1;
            for (int j = 1; j < n - i; ++j) {
                factorial *= j;
            }
          
            // Find the number to put in the current position
            for (int j = 1; j <= n; ++j) {
                if (!visited[j]) {
                    // If the remaining permutations are more than k,
                    // decrease k and find the next number
                    if (k > factorial) {
                        k -= factorial;
                    } else {
                        // Add the number to the result and mark it as visited
                        permutation.append(j);
                        visited[j] = true;
                        break;
                    }
                }
            }
        }
      
        // Return the final permutation string
        return permutation.toString();
    }
}
