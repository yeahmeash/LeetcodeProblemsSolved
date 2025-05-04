import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] numberOfPairs(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        int pairs = 0;
        int leftovers = 0;
        for (int count : frequencyMap.values()) {
            pairs += count / 2;
            leftovers += count % 2;
        }
        
        return new int[]{pairs, leftovers};
    }
}