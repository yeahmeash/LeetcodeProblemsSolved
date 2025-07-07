import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0])); // Sort by startDay
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // stores endDays

        int day = 0, i = 0, res = 0, n = events.length;

        // Go through days while there are events not attended or heap is not empty
        while (i < n || !minHeap.isEmpty()) {
            if (minHeap.isEmpty()) {
                day = events[i][0]; // jump to the next startDay if no active event
            }

            // Add all events that start today
            while (i < n && events[i][0] <= day) {
                minHeap.offer(events[i][1]); // store endDay
                i++;
            }

            // Remove all events that already ended
            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }

            // Attend one event with the earliest endDay
            if (!minHeap.isEmpty()) {
                minHeap.poll();
                res++;
                day++;
            }
        }

        return res;
    }
}
