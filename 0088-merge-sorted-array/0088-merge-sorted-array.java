import java.util.Arrays;

class Solution {

public void merge(int[] nums1, int m, int[] nums2, int n) {
    int p1 = m - 1;           // pointer to end of nums1 data
    int p2 = n - 1;           // pointer to end of nums2
    int p = m + n - 1;        // pointer to end of nums1 array

    while (p1 >= 0 && p2 >= 0) {
        if (nums1[p1] > nums2[p2]) {
            nums1[p--] = nums1[p1--];  // place larger one
        } else {
            nums1[p--] = nums2[p2--];
        }
    }

    // If anything is left in nums2, copy it
    while (p2 >= 0) {
        nums1[p--] = nums2[p2--];
    }
}

}

   
