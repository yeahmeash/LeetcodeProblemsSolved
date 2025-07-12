class Solution {
    // Function to count the number of odd numbers between low and high (inclusive)
    public int countOdds(int low, int high) {
        // ((high + 1) >> 1) calculates the number of odd numbers from 1 to high
        // (low >> 1) calculates the number of odd numbers from 1 to (low - 1)
        // Subtracting the two gives the number of odd numbers between low and high
        return ((high + 1) >> 1) - (low >> 1);
    }
}