class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] result = new int[rows * cols][2];
        int count = 0;
        
        int len = 1; // steps in current direction
        int r = rStart, c = cStart;

        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}}; // right, down, left, up
        int dir = 0;

        while (count < rows * cols) {
            for (int i = 0; i < 2; i++) { // every two directions, increase step length
                for (int j = 0; j < len; j++) {
                    // check bounds before adding
                    if (r >= 0 && r < rows && c >= 0 && c < cols) {
                        result[count++] = new int[]{r, c};
                    }
                    r += directions[dir][0];
                    c += directions[dir][1];
                }
                dir = (dir + 1) % 4;
            }
            len++;
        }

        return result;
    }
}

