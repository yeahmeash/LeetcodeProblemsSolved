import java.util.*;

class MedianFinder {
    private PriorityQueue<Integer> leftmaxheap;  // max-heap for smaller half
    private PriorityQueue<Integer> rightminheap; // min-heap for larger half

    public MedianFinder() {
        leftmaxheap = new PriorityQueue<>(Collections.reverseOrder());
        rightminheap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // Step 1: Add to left heap first
        if (leftmaxheap.isEmpty() || num <= leftmaxheap.peek()) {
            leftmaxheap.offer(num);
        } else {
            rightminheap.offer(num);
        }

        // Step 2: Balance heaps
        if (leftmaxheap.size() > rightminheap.size() + 1) {
            rightminheap.offer(leftmaxheap.poll());
        } else if (leftmaxheap.size() < rightminheap.size()) {
            leftmaxheap.offer(rightminheap.poll());
        }
    }

    public double findMedian() {
        if (leftmaxheap.size() == rightminheap.size()) {
            return (leftmaxheap.peek() + rightminheap.peek()) / 2.0;
        } else {
            return leftmaxheap.peek();
        }
    }
}


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */