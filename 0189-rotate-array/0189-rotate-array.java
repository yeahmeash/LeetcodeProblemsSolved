class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n; // In case k >= n
        reverse(nums, 0, n - 1);       // Reverse entire array
        reverse(nums, 0, k - 1);       // Reverse first k elements
        reverse(nums, k, n - 1);       // Reverse the rest
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }
}
