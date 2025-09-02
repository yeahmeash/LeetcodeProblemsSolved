import java.util.*;

public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            res[i] = -1; // default
            // find nums1[i] in nums2
            int pos = -1;
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == nums1[i]) {
                    pos = j;
                    break;
                }
            }
            // look to the right in nums2
            for (int j = pos + 1; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    res[i] = nums2[j];
                    break;
                }
            }
        }
        return res;
    }
}
