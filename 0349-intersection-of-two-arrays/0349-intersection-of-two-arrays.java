class Solution {
  public int[] intersection(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);  // Step 1
    Arrays.sort(nums2);

    Set<Integer> result = new HashSet<>();  // Step 2

    int i = 0, j = 0;  // Two pointers
    while (i < nums1.length && j < nums2.length) {
        if (nums1[i] == nums2[j]) {
            result.add(nums1[i]);
            i++;
            j++;
        } else if (nums1[i] < nums2[j]) {
            i++;
        } else {
            j++;
        }
    }

    int[] res = new int[result.size()];
    int idx = 0;
    for (int num : result) res[idx++] = num;
    return res;
}

}