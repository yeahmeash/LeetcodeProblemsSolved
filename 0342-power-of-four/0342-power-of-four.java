class Solution {
    public boolean isPowerOfFour(int n) {
        if (n <= 0)
            return false;
        long temp = 1;
        int i = 0;
        while (true){
            if (temp == n){
                return true;
            } else if (temp > n){
                return false;
            }
            temp *= 4;
            i++;
        }
    }
}