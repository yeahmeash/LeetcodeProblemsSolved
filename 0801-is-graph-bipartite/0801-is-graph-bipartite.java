import java.util.*;

public class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);  // -1 means uncolored

        // For disconnected graphs, check each component
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!dfs(graph, i, 0, color)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(int[][] graph, int node, int c, int[] color) {
        color[node] = c;

        for (int neighbor : graph[node]) {
            if (color[neighbor] == -1) {
                // Color neighbor with opposite color
                if (!dfs(graph, neighbor, 1 - c, color)) {
                    return false;
                }
            } else if (color[neighbor] == color[node]) {
                // Same color neighbor → not bipartite
                return false;
            }
        }

        return true;
    }
}