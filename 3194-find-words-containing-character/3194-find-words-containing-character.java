import java.util.*;

public class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(x) != -1) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] words = {"leet", "code"};
        char x = 'e';
        System.out.println(sol.findWordsContaining(words, x));  // Output: [0, 1]
    }
}

