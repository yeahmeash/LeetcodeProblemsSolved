class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
		//In the minHeap array, 0th element refers to the curr element in nums1 and 1st element refers to curr element in nums2 
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> (a[0] + a[1]) - (b[0] + b[1]));
        
		// The 2nd element in the minHeap is the index of nums2, the corresponding element of nums2 is in index1 of minHeap
        for(int i=0; i < nums1.length && i < k; i++)
            minHeap.add(new int[]{nums1[i], nums2[0], 0});
        
        List<List<Integer>> result = new ArrayList<>();
        
       for(int i=0; i < k && !minHeap.isEmpty(); i++){

          int[] curr = minHeap.poll();         // 1️⃣ take out the smallest sum pair
           result.add(List.of(curr[0], curr[1])); // 2️⃣ record it in result

            int nums2Idx = curr[2];              // 3️⃣ track which index of nums2 we used

            if(nums2Idx < nums2.length - 1)      // 4️⃣ if nums2 has more elements
        minHeap.add(new int[]{curr[0], nums2[nums2Idx + 1], nums2Idx + 1});

        // curr[0] → same nums1 element (stay fixed)
        // nums2[nums2Idx + 1] → the next element in nums2
        // nums2Idx + 1 → updated index in nums2 (so we can continue moving forward later)
}

        return result;
    }
}