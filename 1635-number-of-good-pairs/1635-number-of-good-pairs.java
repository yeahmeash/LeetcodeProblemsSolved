import java.util.HashMap;

class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int goodPairs = 0;

        for (int num : nums) {
            if (freq.containsKey(num)) {
                goodPairs += freq.get(num);
            }
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        return goodPairs;
    }
}
