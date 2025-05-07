import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int minTimeToReach(int[][] moveTime) {
        // Get the number of rows (n) and columns (m) from the moveTime matrix
        int n = moveTime.length;
        int m = moveTime[0].length;

        // Initialize a distance matrix filled with maximum integer values
        int[][] distance = new int[n][m];
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Starting point (0, 0) has a distance of 0
        distance[0][0] = 0;
      
        // Priority queue to store cells in the form [current_distance, row, column]
        // Sorted by current_distance
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        priorityQueue.offer(new int[] {0, 0, 0});

        // Directions arrays for moving up, down, left, and right
        int[] directions = {-1, 0, 1, 0, -1};

        // Process until we find the minimum distance to the bottom-right corner
        while (true) {
            // Get the element with the smallest distance
            int[] current = priorityQueue.poll();
            int currentDistance = current[0];
            int i = current[1];
            int j = current[2];

            // Check if we've reached the bottom-right corner
            if (i == n - 1 && j == m - 1) {
                return currentDistance;
            }

            // If there is already a better distance, continue
            if (currentDistance > distance[i][j]) {
                continue;
            }

            // Explore all four possible directions (up, down, left, right)
            for (int k = 0; k < 4; k++) {
                int x = i + directions[k];
                int y = j + directions[k + 1];
              
                // Check if new position is within bounds
                if (x >= 0 && x < n && y >= 0 && y < m) {
                    // Calculate new time distance for this position
                    int newTime = Math.max(moveTime[x][y], distance[i][j]) + 1;

                    // If this path offers a shorter distance, update and enqueue
                    if (distance[x][y] > newTime) {
                        distance[x][y] = newTime;
                        priorityQueue.offer(new int[] {newTime, x, y});
                    }
                }
            }
        }
    }
}
