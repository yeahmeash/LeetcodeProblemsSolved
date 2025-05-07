class Solution {
    public String getRange(int left, int right){
        if (left == right){
            return String.valueOf(left);
        }
        StringBuilder res = new StringBuilder();
        res.append(left);
        res.append("->");
        res.append(right);
        return res.toString();
    }

    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> result = new ArrayList<>();
        if (n == 0){
            return result;
        }
        int left = nums[0];
        int right = left;
        for (int i = 1; i < n; i++){
            if (nums[i] == right + 1){
                right++;
            }
            else{
                result.add(getRange(left, right));
                left = nums[i];
                right = left;
            }
        }
        result.add(getRange(left, right));
        return result;
    }
}
