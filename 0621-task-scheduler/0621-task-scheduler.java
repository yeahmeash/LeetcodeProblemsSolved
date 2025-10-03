class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Step 1: Count frequency of each task
        int[] freq = new int[26];
        for (char c : tasks) freq[c - 'A']++;

        // Step 2: Max-heap to always pick the task with highest remaining count
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int f : freq) if (f > 0) pq.offer(f);

        int time = 0;

        // Step 3: Process tasks in cycles of length n+1
        while (!pq.isEmpty()) {
            List<Integer> temp = new ArrayList<>(); // tasks used in this cycle
            int cycle = n + 1;

            // Pick up to n+1 tasks
            while (cycle > 0 && !pq.isEmpty()) {
                int count = pq.poll();
                if (count - 1 > 0) temp.add(count - 1); // decrement count if task still remains
                time++;
                cycle--;
            }

            // Push remaining tasks back into heap
            for (int t : temp) pq.offer(t);

            // If heap is empty, last cycle may be shorter than n+1, no idle needed
            if (!pq.isEmpty()) time += cycle; // add idle time if tasks remain
        }

        return time;
    }
}
