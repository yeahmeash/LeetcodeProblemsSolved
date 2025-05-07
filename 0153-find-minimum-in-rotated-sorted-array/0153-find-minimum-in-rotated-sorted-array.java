class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;  // Minimum is in the right half
            } else {
                right = mid;  // Minimum is in the left half or at mid
            }
        }

        return nums[left];  // or nums[right] — both are the same at this point
    }
}
