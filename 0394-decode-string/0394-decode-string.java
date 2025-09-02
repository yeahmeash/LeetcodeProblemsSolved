class Solution {
    public String decodeString(String s) {
    return dfs(s.toCharArray(), new int[]{0});
}

private String dfs(char[] arr, int[] idx) {
    StringBuilder curr = new StringBuilder();
    int num = 0;

    while (idx[0] < arr.length) {
        char ch = arr[idx[0]];
        if (Character.isDigit(ch)) {
            num = num * 10 + (ch - '0');
        } else if (ch == '[') {
            idx[0]++;
            String sub = dfs(arr, idx);
            curr.append(sub.repeat(num));
            num = 0;
        } else if (ch == ']') {
            return curr.toString();
        } else {
            curr.append(ch);
        }
        idx[0]++;
    }
    return curr.toString();
}

}