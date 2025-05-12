import java.util.*;

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> result = new HashSet<>();
        int n = digits.length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (i == j || j == k || i == k) continue;
                    int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                    if (digits[i] != 0 && num % 2 == 0) {
                        result.add(num);
                    }
                }
            }
        }
        
        List<Integer> sortedList = new ArrayList<>(result);
        Collections.sort(sortedList);
        
        int[] sortedArray = new int[sortedList.size()];
        for (int i = 0; i < sortedList.size(); i++) {
            sortedArray[i] = sortedList.get(i);
        }
        
        return sortedArray;
    }
}