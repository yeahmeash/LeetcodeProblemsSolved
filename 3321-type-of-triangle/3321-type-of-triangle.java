class Solution {
    public String triangleType(int[] nums) {
        // Sort the array to make triangle inequality check easier
        Arrays.sort(nums);

        // Triangle inequality: sum of two smaller sides must be greater than the largest
        if (nums[0] + nums[1] <= nums[2]) {
            return "none";
        }

        // Check for equilateral
        if (nums[0] == nums[1] && nums[1] == nums[2]) {
            return "equilateral";
        }

        // Check for isosceles
        if (nums[0] == nums[1] || nums[1] == nums[2] || nums[0] == nums[2]) {
            return "isosceles";
        }

        // If all sides are different
        return "scalene";
    }
}
