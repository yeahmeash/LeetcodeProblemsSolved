class Solution {

    // Function to check if it is safe to place num at board[row][col]
    static boolean isSafe(char[][] board, int row, int col, char num) {
        // Check if num exists in the row
        for (int x = 0; x < 9; x++)
            if (board[row][x] == num)
                return false;

        // Check if num exists in the col
        for (int x = 0; x < 9; x++)
            if (board[x][col] == num)
                return false;

        // Check if num exists in the 3x3 sub-matrix
        int startRow = row - (row % 3), startCol = col - (col % 3);

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i + startRow][j + startCol] == num)
                    return false;

        return true;
    }

    // Function to solve the Sudoku problem
    static boolean solveSudokuRec(char[][] board, int row, int col) {
      
        // base case: Reached nth column of the last row
        if (row == 8 && col == 9)
            return true;

        // If last column of the row go to the next row
        if (col == 9) {
            row++;
            col = 0;
        }

        // If cell is already occupied then move forward
        if (board[row][col] != '.')
            return solveSudokuRec(board, row, col + 1);

        for (char num = '1'; num <= '9'; num++) {
          
            // If it is safe to place num at current position
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (solveSudokuRec(board, row, col + 1))
                    return true;
                board[row][col] = '.';
            }
        }

        return false;
    }

    public void solveSudoku(char[][] board) {
        solveSudokuRec(board, 0, 0);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {
            {'3', '.', '6', '5', '.', '8', '4', '.', '.'},
            {'5', '2', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '8', '7', '.', '.', '.', '.', '3', '1'},
            {'.', '.', '3', '.', '1', '.', '.', '8', '.'},
            {'9', '.', '.', '8', '6', '3', '.', '.', '5'},
            {'.', '5', '.', '.', '9', '.', '6', '.', '.'},
            {'1', '3', '.', '.', '.', '.', '2', '5', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '7', '4'},
            {'.', '.', '5', '2', '.', '6', '3', '.', '.'}
        };

        solution.solveSudoku(board);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }
}
