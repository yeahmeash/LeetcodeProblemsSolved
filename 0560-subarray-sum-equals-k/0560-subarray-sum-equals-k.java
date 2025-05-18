import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0, 1);  // sum 0 occurs once

        int count = 0;
        int prefixSum = 0;

        for (int num : nums) {
            prefixSum += num;

            if (prefixSums.containsKey(prefixSum - k)) {
                count += prefixSums.get(prefixSum - k);
            }

            prefixSums.put(prefixSum, prefixSums.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}
