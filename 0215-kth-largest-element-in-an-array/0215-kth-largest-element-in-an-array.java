import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Min-heap to store the K largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        // Iterate through the array
        for (int num : nums) {
            minHeap.offer(num); // Add element to the heap
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the smallest element (heap root) if size exceeds k
            }
        }

        // The root of the heap is the Kth largest element
        return minHeap.peek();
    }
}
