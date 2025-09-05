class KthLargest {
    int k;
    List<Integer> nums;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = new ArrayList<>();
        for (int num : nums) this.nums.add(num);
    }

    public int add(int val) {
        nums.add(val);
        Collections.sort(nums, Collections.reverseOrder());
        return nums.get(k - 1);
    }
}


/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */