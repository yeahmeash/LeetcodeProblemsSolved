class Solution {
    int n;
    public int snakesAndLadders(int[][] board) {
        n = board.length;
        boolean visited[] = new boolean[n*n + 1];
        Queue<Integer> blocks = new ArrayDeque<>();
        blocks.offer(1);
        int count = 0;
        while(!blocks.isEmpty()) {
            int size = blocks.size();
            count++;
            for(int i = 0; i < size; i++) {
                int curr = blocks.poll();
                System.out.println(curr);
                if(visited[curr]) continue;
                visited[curr] = true;
                for(int j = 1; j <= 6; j++) {
                    if((curr + j) >= (n * n)) {
                        return count;
                    }
                    int[] coordinates = getCoordinates(curr + j);
                    if(board[coordinates[0]][coordinates[1]] != -1) {
                        if(board[coordinates[0]][coordinates[1]] >= (n * n)) return count;
                        blocks.offer(board[coordinates[0]][coordinates[1]]);
                    } else {
                        blocks.offer(curr + j);
                    }
                }
            }
        }
        return -1;
    }

    private int[] getCoordinates(int curr) {
        int x = ((int)((curr-1) / n));
        int y = (curr-1) % n;
        if(x % 2 != 0) {
            y = n - y - 1;
        }
        return new int[] {n - x - 1, y};
    }
}