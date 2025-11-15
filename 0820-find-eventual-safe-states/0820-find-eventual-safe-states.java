class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        // visited: fully processed, path: on current recursion path, check: final safe status
        boolean[] visited = new boolean[n];
        boolean[] path = new boolean[n];
        boolean[] check = new boolean[n];
        
        for(int i=0;i<n;i++){
            if(visited[i] == false){
                dfs(i,graph,visited,path,check);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        // Collect all nodes marked safe
        for(int i = 0; i<n; i++) {
            if(check[i] == true) safeNodes.add(i);
        }
        return safeNodes;
    }

    // Returns true if a cycle is found
    boolean dfs(int node, int[][] graph, boolean[] visited, boolean[] path, boolean[] check){
        visited[node] = true;
        path[node] = true;
        check[node] = false; // Assume unsafe initially
        
        for(int adj : graph[node]){
            if(visited[adj] == false){
                if(dfs(adj,graph,visited,path,check) == true) return true;
            }
            else if(path[adj] == true) return true; // Cycle detected
        }

        path[node] = false; // Remove from current path
        check[node] = true; // Mark as safe
        return false;
    }
}