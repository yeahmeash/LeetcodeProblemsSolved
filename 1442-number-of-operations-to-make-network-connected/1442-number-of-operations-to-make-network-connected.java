class Solution {
    int parent[];
    int rank[];

    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    public boolean union(int a, int b) {
        int px = find(a), py = find(b);
        if (px == py) return false;
        if (rank[px] < rank[py]) parent[px] = py;
        else if (rank[py] < rank[px]) parent[py] = px;
        else {
            parent[py] = px;
            rank[px]++;
        }
        return true;
    }

    public int makeConnected(int n, int[][] connections) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        int extraEdges = 0;
        for (int[] edge : connections) {
            if (!union(edge[0], edge[1])) extraEdges++;
        }

        int components = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) components++;
        }

        int need = components - 1;
        return extraEdges >= need ? need : -1;
    }
}