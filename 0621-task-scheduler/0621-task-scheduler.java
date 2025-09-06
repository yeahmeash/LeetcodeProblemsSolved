class Solution {
  public int leastInterval(char[] tasks, int n) {
    int[] freq = new int[26];
    for (char t : tasks) freq[t - 'A']++;

    int maxFreq = 0, maxCount = 0;
    for (int f : freq) {
        if (f == maxFreq) maxCount++;
        else if (f > maxFreq) {
            maxFreq = f;
            maxCount = 1;
        }
    }

    // Math formula
    int partCount = maxFreq - 1;
    int partLength = n + 1;
    int emptySlots = partCount * partLength + maxCount;

    return Math.max(tasks.length, emptySlots);
}

}