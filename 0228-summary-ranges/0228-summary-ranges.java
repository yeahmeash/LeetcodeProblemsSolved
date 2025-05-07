class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        
        if (nums.length == 0) {
            return result;  // If the array is empty, return an empty list
        }
        
        int start = nums[0];  // Start of the current range
        
        for (int i = 1; i < nums.length; i++) {
            // Check if the current number is consecutive
            if (nums[i] != nums[i - 1] + 1) {
                // If not, close the current range
                if (start == nums[i - 1]) {
                    result.add(String.valueOf(start));  // Single number range
                } else {
                    result.add(start + "->" + nums[i - 1]);  // Range with more than one number
                }
                // Start a new range
                start = nums[i];
            }
        }
        
        // Add the last range (after the loop)
        if (start == nums[nums.length - 1]) {
            result.add(String.valueOf(start));  // Single number range
        } else {
            result.add(start + "->" + nums[nums.length - 1]);  // Range with more than one number
        }
        
        return result;
    }
}
