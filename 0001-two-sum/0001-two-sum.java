import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {  // use < instead of <=
            int complement = target - nums[i];

            if (map.containsKey(complement)) {   // fix typo: containsKey, not containsket
                return new int[] { map.get(complement), i };
            }

            map.put(nums[i], i);  // fix typo: nums, not num
        }

        throw new IllegalArgumentException("No two sum solution found"); // Fix capitalization
    }
}
