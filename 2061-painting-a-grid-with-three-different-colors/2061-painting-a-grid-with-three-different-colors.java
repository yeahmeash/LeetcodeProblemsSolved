class Solution {
    static final int MOD = 1_000_000_007;

    public int colorTheGrid(int m, int n) {
        List<int[]> validCols = new ArrayList<>();
        generateColumns(new int[m], 0, validCols);

        // Map current column state to list of compatible previous states
        Map<String, List<String>> compatible = new HashMap<>();
        for (int[] curr : validCols) {
            String key = toKey(curr);
            compatible.putIfAbsent(key, new ArrayList<>());
            for (int[] prev : validCols) {
                if (isCompatible(prev, curr)) {
                    compatible.get(key).add(toKey(prev));
                }
            }
        }

        // DP initialization
        Map<String, Integer> dp = new HashMap<>();
        for (int[] col : validCols) {
            dp.put(toKey(col), 1);
        }

        // Iterate column by column
        for (int col = 1; col < n; col++) {
            Map<String, Integer> newDp = new HashMap<>();
            for (String curr : dp.keySet()) {
                for (String prev : compatible.get(curr)) {
                    newDp.put(curr, (newDp.getOrDefault(curr, 0) + dp.get(prev)) % MOD);
                }
            }
            dp = newDp;
        }

        // Sum all possibilities
        int result = 0;
        for (int count : dp.values()) {
            result = (result + count) % MOD;
        }
        return result;
    }

    // Generate all valid column colorings (no vertical adjacent same color)
    private void generateColumns(int[] path, int i, List<int[]> result) {
        if (i == path.length) {
            result.add(path.clone());
            return;
        }
        for (int c = 0; c < 3; c++) {
            if (i > 0 && path[i - 1] == c) continue;
            path[i] = c;
            generateColumns(path, i + 1, result);
        }
    }

    // Check horizontal compatibility (no same color at same row between two columns)
    private boolean isCompatible(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[i]) return false;
        }
        return true;
    }

    // Convert int[] to string key
    private String toKey(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int val : arr) sb.append(val);
        return sb.toString();
    }
}
