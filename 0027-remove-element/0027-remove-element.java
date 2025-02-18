class Solution {
    public int removeElement(int[] nums, int val) {
        int newIndex = 0; // Index to place the next non-val element

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != val) {
                nums[newIndex] = nums[i];
                newIndex++;
            }
        }

        return newIndex; // Return the new length of the array after removal
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {3, 2, 2, 3}; // Example input array
        int val = 3;               // Value to remove

        int newLength = solution.removeElement(nums, val);

        System.out.println("New length: " + newLength);
        System.out.print("Modified array: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}