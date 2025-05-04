import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> count = new HashMap<>();
        int pairs = 0;
        
        for (int[] domino : dominoes) {
            int a = domino[0];
            int b = domino[1];
            String key = (a <= b) ? a + "," + b : b + "," + a;
            int currentCount = count.getOrDefault(key, 0);
            pairs += currentCount;
            count.put(key, currentCount + 1);
        }
        
        return pairs;
    }
}