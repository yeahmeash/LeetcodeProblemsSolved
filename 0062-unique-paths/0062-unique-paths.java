class Solution {
    public int uniquePaths(int m, int n) {
        // Create an array to store the number of unique paths to each cell in the bottom row.
        int[] pathCounts = new int[n];
      
        // Initialize the bottom row with 1s since there's only one way to reach each cell in the bottom row
        // when only moving right.
        Arrays.fill(pathCounts, 1);

        // Loop over each cell starting from the second row up to the top row (since the bottom row is already filled).
        for (int row = 1; row < m; ++row) {
            // For each cell in a row, start from the second column since the first column of any row
            // will only have one unique path (i.e., moving down from the cell above).
            for (int col = 1; col < n; ++col) {
                // The number of unique paths to the current cell is the sum of the unique paths to the cell
                // directly above it and to the cell to the left of it.
                pathCounts[col] += pathCounts[col - 1];
            }
        }
      
        // Return the number of unique paths to the top-right corner of the grid.
        return pathCounts[n - 1];
    }
}