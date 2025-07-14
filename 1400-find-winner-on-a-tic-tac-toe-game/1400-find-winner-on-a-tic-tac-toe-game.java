class Solution {
   public String tictactoe(int[][] moves) {
    int[] rows = new int[3];
    int[] cols = new int[3];
    int diag = 0, antiDiag = 0;

    for (int i = 0; i < moves.length; i++) {
        int r = moves[i][0], c = moves[i][1];
        int player = (i % 2 == 0) ? 1 : -1;

        rows[r] += player;
        cols[c] += player;

        if (r == c) diag += player;
        if (r + c == 2) antiDiag += player;

        if (Math.abs(rows[r]) == 3 || Math.abs(cols[c]) == 3 ||
            Math.abs(diag) == 3 || Math.abs(antiDiag) == 3) {
            return player == 1 ? "A" : "B";
        }
    }

    return moves.length == 9 ? "Draw" : "Pending";
}

}