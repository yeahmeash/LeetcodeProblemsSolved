class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0; // If the array is empty, return 0
        }

        int slow = 0; // Pointer to track the position of the last unique element
        for (int fast = 1; fast < n; fast++) {
            if (nums[fast] != nums[slow]) {
                slow++; // Move the slow pointer
                nums[slow] = nums[fast]; // Copy the unique element to the slow position
            }
        }

        return slow + 1; // Return the number of unique elements
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {1, 1, 2, 2, 3, 4, 4, 5}; // Example input array

        int newLength = solution.removeDuplicates(nums);

        System.out.println("New length: " + newLength);
        System.out.print("Modified array: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}