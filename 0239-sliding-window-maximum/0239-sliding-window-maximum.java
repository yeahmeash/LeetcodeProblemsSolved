class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        // store [value, index]

        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
            
            // Remove out-of-window elements
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }

            // Start recording results once we have first window
            if (i >= k - 1) {
                res[i - k + 1] = pq.peek()[0];
            }
        }
        return res;
    }
}
