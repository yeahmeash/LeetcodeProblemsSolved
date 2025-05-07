import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Min-heap to store pairs (sum, i, j), where i is index in nums1, and j is index in nums2
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));

        // Initialize the heap with the first element of nums1 and all elements of nums2
        for (int i = 0; i < nums1.length && i < k; i++) {
            minHeap.offer(new int[]{nums1[i] + nums2[0], i, 0});
        }

        // Extract the smallest pairs from the heap
        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int sum = curr[0], i = curr[1], j = curr[2];
            
            // Convert int[] to List<Integer>
            List<Integer> pair = new ArrayList<>();
            pair.add(nums1[i]);
            pair.add(nums2[j]);
            result.add(pair);
            
            // If there is a next element in nums2, add the new pair (nums1[i], nums2[j+1])
            if (j + 1 < nums2.length) {
                minHeap.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
            }
        }
        
        return result;
    }
}

