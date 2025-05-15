class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            sum += mat[i][i];             // Primary diagonal
            sum += mat[i][n - 1 - i];     // Secondary diagonal
        }
        
        // Subtract middle element if n is odd (to avoid double-counting)
        if (n % 2 == 1) {
            sum -= mat[n / 2][n / 2];
        }
        
        return sum;
    }
}
