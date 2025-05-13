public class Solution {
    private static final int MOD = 1000000007;

    public int lengthAfterTransformations(String s, int t) {
        long[] count = new long[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (int i = 0; i < t; i++) {
            long[] newCount = new long[26];
            for (int j = 0; j < 26; j++) {
                if (j != 25) {
                    newCount[j + 1] = (newCount[j + 1] + count[j]) % MOD;
                } else {
                    newCount[0] = (newCount[0] + count[j]) % MOD;
                    newCount[1] = (newCount[1] + count[j]) % MOD;
                }
            }
            count = newCount;
        }

        long total = 0;
        for (long num : count) {
            total = (total + num) % MOD;
        }
        return (int) total;
    }
}