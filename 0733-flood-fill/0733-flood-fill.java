public class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor != newColor) {
            dfs(image, sr, sc, oldColor, newColor);
        }
        return image;
    }

    private void dfs(int[][] image, int r, int c, int oldColor, int newColor) {
        int rows = image.length;
        int cols = image[0].length;

        // Base case: out of bounds or not same color
        if (r < 0 || c < 0 || r >= rows || c >= cols || image[r][c] != oldColor)
            return;

        // Change color
        image[r][c] = newColor;

        // Recurse 4 directions
        dfs(image, r + 1, c, oldColor, newColor);
        dfs(image, r - 1, c, oldColor, newColor);
        dfs(image, r, c + 1, oldColor, newColor);
        dfs(image, r, c - 1, oldColor, newColor);
    }
}
