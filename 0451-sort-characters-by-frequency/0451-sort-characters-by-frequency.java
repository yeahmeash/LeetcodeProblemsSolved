import java.util.*;

class Solution {
    public String frequencySort(String s) {
        // Step 1: Count frequency of each character
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Step 2: Create a max heap (priority queue) based on frequency
        // Characters with higher frequency come out first
        PriorityQueue<Character> pq = new PriorityQueue<>(
            (a, b) -> freq.get(b) - freq.get(a)
        );

        // Add all unique characters to the heap
        pq.addAll(freq.keySet());

        // Step 3: Build the result string
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            // Extract character with highest frequency
            char c = pq.poll();
            int count = freq.get(c);

            // Append this character 'count' times to result
            for (int i = 0; i < count; i++) {
                sb.append(c);
            }
        }

        // Step 4: Return final string
        return sb.toString();
    }
}
