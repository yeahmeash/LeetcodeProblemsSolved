class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int maxBottles = 0;
        int empties = 0;
        
        while (numBottles > 0) {
            maxBottles += numBottles;      // drink them
            empties += numBottles;         // now you have these empties
            numBottles = empties / numExchange;  // exchange for new full bottles
            empties = empties % numExchange;     // leftovers remain
        }
        
        return maxBottles;
    }
}
