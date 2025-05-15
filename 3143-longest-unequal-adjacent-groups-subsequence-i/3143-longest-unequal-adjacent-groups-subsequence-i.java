import java.util.*;

class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> res = new ArrayList<>();
        if (words.length == 0) return res;

        res.add(words[0]);
        int prevGroup = groups[0];

        for (int i = 1; i < words.length; i++) {
            if (groups[i] != prevGroup) {
                res.add(words[i]);
                prevGroup = groups[i];
            }
        }

        return res;
    }
}
