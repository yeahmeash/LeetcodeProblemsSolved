class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        if (intervals.length == 0) return 0;

        // Sort by end time
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int remove = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            // Overlap
            if (intervals[i][0] < prevEnd) {
                remove++;
            } else {
                prevEnd = intervals[i][1];
            }
        }

        return remove;
    }
}
