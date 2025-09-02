class Solution {
    public int maxDepth(String s) {
        int maxDepthCount = 0;
        int depthCount = 0;

        for(char i : s.toCharArray()){
            if(i == '('){
                depthCount++;

                if(depthCount > maxDepthCount) maxDepthCount = depthCount;
            }
            else if(i == ')') depthCount--;
        }
        return maxDepthCount;
    }
}