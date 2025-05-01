class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;  // Choose new candidate
            }

            // Vote: +1 for same, -1 for different
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;  // Assumes majority element always exists
    }
}
