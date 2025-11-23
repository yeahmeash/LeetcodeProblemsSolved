import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // Graph as adjacency list: graph[a] holds all courses that depend on course 'a'
        List<List<Integer>> graph = new ArrayList<>();

        // inDegree[i] = number of prerequisites for course i
        int[] inDegree = new int[numCourses];

        // Initialize graph with empty lists
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph
        // For each edge [course, prereq], prereq → course
        for (int[] edge : prerequisites) {
            int course = edge[0];
            int prereq = edge[1];

            // prereq leads to course
            graph.get(prereq).add(course);

            // increase inDegree because course has one more prerequisite
            inDegree[course]++;
        }

        // Queue for all courses with no prerequisites
        Queue<Integer> queue = new LinkedList<>();

        // Add all nodes with inDegree 0 (they can be taken immediately)
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // To store the order in which we can complete courses
        int[] order = new int[numCourses];
        int index = 0;

        // Standard BFS for Topological Sort (Kahn’s algorithm)
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            order[index++] = curr;  // Add course to the final order

            // Reduce inDegree of neighbors (courses dependent on curr)
            for (int neighbor : graph.get(curr)) {
                inDegree[neighbor]--;

                // If inDegree becomes zero, add to queue
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // If we visited all courses, return the order. Otherwise cycle exists → return empty array.
        return index == numCourses ? order : new int[0];
    }
}
