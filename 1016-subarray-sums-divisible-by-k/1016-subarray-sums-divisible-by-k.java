class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> remainderCount = new HashMap<>();
        remainderCount.put(0, 1); // To count subarrays that start from index 0
        
        int sum = 0, count = 0;

        for (int num : nums) {
            sum += num;
            int remainder = sum % k;

            // Handle negative remainders
            if (remainder < 0) remainder += k;

            // If this remainder has been seen, add the count
            count += remainderCount.getOrDefault(remainder, 0);

            // Update the count of this remainder
            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }
}
