import java.util.*;

class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[n];
        int[][] dp = new int[n][26]; // dp[node][color]

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        // Build graph
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) queue.offer(i);
            dp[i][colors.charAt(i) - 'a'] = 1;
        }

        int visited = 0;
        int max = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited++;

            for (int neighbor : graph.get(node)) {
                for (int c = 0; c < 26; c++) {
                    int val = dp[node][c] + (colors.charAt(neighbor) - 'a' == c ? 1 : 0);
                    dp[neighbor][c] = Math.max(dp[neighbor][c], val);
                }

                if (--inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }

            // Update global max
            for (int c = 0; c < 26; c++) {
                max = Math.max(max, dp[node][c]);
            }
        }

        return visited == n ? max : -1;
    }
}
