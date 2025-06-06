class Solution {
    public List<Integer> findLonely(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for (int num : freq.keySet()) {
            if (freq.get(num) == 1 &&
                !freq.containsKey(num - 1) &&
                !freq.containsKey(num + 1)) {
                result.add(num);
            }
        }

        return result;
    }
}
