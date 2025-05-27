class Solution {
    public int differenceOfSums(int n, int m) {
        long totalSum = (long) n * (n + 1) / 2;

        long k = n / m;
        long divisibleSum = m * k * (k + 1) / 2;

        long nonDivisibleSum = totalSum - divisibleSum;

        return (int)(nonDivisibleSum - divisibleSum);
    }
}
