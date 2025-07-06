import java.util.Arrays;

class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr); // Sort the array

        int diff = arr[1] - arr[0]; // Calculate the common difference

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != diff) {
                return false; // If any consecutive pair doesn't match the common difference
            }
        }

        return true;
    }
}
