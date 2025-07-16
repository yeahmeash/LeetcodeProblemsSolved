class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;  // Already valid

        int i = 2;  // Start from third position

        for (int j = 2; j < nums.length; j++) {
            // Check if nums[j] is not equal to nums[i - 2]
            if (nums[j] != nums[i - 2]) {
                nums[i] = nums[j];  // Copy valid element
                i++;
            }
        }

        return i;
    }
}

