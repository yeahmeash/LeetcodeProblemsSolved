class Solution {
  public int[] nextGreaterElements(int[] nums) {
    int n = nums.length;
    int[] res = new int[n];
    Stack<Integer> stack = new Stack<>();

    for (int i = 2 * n - 1; i >= 0; i--) {
        int num = nums[i % n];
        while (!stack.isEmpty() && stack.peek() <= num) {
            stack.pop();
        }
        if (i < n) {
            res[i] = stack.isEmpty() ? -1 : stack.peek();
        }
        stack.push(num);
    }
    return res;
}

}