class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        
        int left = 0, right = n - 1;
        int top = 0, bottom = n - 1;
        int num = 1;

        while (left <= right && top <= bottom) {
            // Left to right
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            top++;

            // Top to bottom
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--;

            // Right to left
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = num++;
            }
            bottom--;

            // Bottom to top
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = num++;
            }
            left++;
        }

        return matrix;
    }
}
