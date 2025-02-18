import java.util.Arrays;

class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Declare 2 pointers:
        int left = m - 1; // Pointer for nums1
        int right = 0;    // Pointer for nums2

        // Swap the elements until nums1[left] is smaller than nums2[right]:
        while (left >= 0 && right < n) {
            if (nums1[left] > nums2[right]) {
                // Swap elements
                int temp = nums1[left];
                nums1[left] = nums2[right];
                nums2[right] = temp;
                left--;
                right++;
            } else {
                break;
            }
        }

        // Sort nums1 and nums2 individually:
        Arrays.sort(nums1, 0, m); // Sort only the first m elements of nums1
        Arrays.sort(nums2);       // Sort all elements of nums2

        // Copy elements from nums2 to nums1 starting from index m:
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1, 4, 8, 10, 0, 0, 0}; // nums1 has extra space for nums2
        int[] nums2 = {2, 3, 9};
        int m = 4; // Number of elements in nums1
        int n = 3; // Number of elements in nums2

        solution.merge(nums1, m, nums2, n);

        System.out.println("The merged array is:");
        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }
}