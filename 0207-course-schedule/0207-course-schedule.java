class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Build adjacency list: adj[a] = list of courses that depend on course a
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            adj.add(new ArrayList<>());

        // For each [course, prereq], create an edge prereq → course
        for (int[] pre : prerequisites)
            adj.get(pre[1]).add(pre[0]);

        // vis[i] → have we completely processed node i before?
        boolean[] vis = new boolean[numCourses];

        // path[i] → is node i currently in the DFS recursion path?
        // This is how we detect cycles.
        boolean[] path = new boolean[numCourses];

        // Try to DFS from every course that hasn't been visited yet
        for (int i = 0; i < numCourses; i++)
            // If dfs returns true → cycle detected → cannot finish all courses
            if (!vis[i] && dfs(i, adj, vis, path)) return false;

        return true;  // no cycle found → courses can be completed
    }

    private boolean dfs(int node, List<List<Integer>> adj, boolean[] vis, boolean[] path) {

        // Mark current node as visited AND part of the current recursion path
        vis[node] = true;
        path[node] = true;

        // Explore neighbors (courses that depend on this course)
        for (int next : adj.get(node)) {

            // If neighbor is not visited, DFS into it
            // If that DFS finds a cycle, return true
            if (!vis[next] && dfs(next, adj, vis, path)) return true;

            // If neighbor is already in the current call-stack path → cycle found
            else if (path[next]) return true;
        }

        // Backtrack: remove node from recursion path
        path[node] = false;

        // No cycle found through this node
        return false;
    }
}
