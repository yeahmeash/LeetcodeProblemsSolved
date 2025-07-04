import java.util.Arrays;

class Solution {
  public int findLongestChain(int[][] pairs) {
    int ans = 0;
    int prevEnd = Integer.MIN_VALUE;

    Arrays.sort(pairs, Comparator.comparingInt(pair -> pair[1]));

    for (int[] pair : pairs)
      if (pair[0] > prevEnd) {
        ++ans;
        prevEnd = pair[1];
      }

    return ans;
  }
}