import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String largestNumber(int[] nums) {
        // Convert each number to a string
        String[] numStrings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrings[i] = String.valueOf(nums[i]);
        }
        
        // Custom comparator to sort in descending order of concatenated value
        Arrays.sort(numStrings, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1);
            }
        });
        
        // Handle the case where the largest number is 0
        if (numStrings[0].equals("0")) {
            return "0";
        }
        
        // Concatenate all strings to form the largest number
        StringBuilder result = new StringBuilder();
        for (String numStr : numStrings) {
            result.append(numStr);
        }
        
        return result.toString();
    }
}