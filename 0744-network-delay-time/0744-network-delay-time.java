import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Build adjacency list: u -> list of (v, w)
        List<int[]>[] g = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++)
         g[i] = new ArrayList<>();

        for (int[] e : times) 
        g[e[0]].add(new int[]{e[1], e[2]});

        // Distances init to "infinity"
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // Min-heap: (timeSoFar, node)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, k});

        boolean[] done = new boolean[n + 1]; // finalized nodes

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int t = cur[0], u = cur[1];
            if (done[u]) continue;         // already finalized via a shorter path
            done[u] = true;

            for (int[] edge : g[u]) {
                int v = edge[0], w = edge[1];
                if (!done[v] && t + w < dist[v]) {
                    dist[v] = t + w;
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1; // unreachable node
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}
