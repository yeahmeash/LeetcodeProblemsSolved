class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;

        // Loop until both strings are processed or there's a carry left
        while (i >= 0 || j >= 0 || carry != 0) {
            // Get the current bits, if out of bounds use 0
            int bitA = (i >= 0) ? a.charAt(i) - '0' : 0;
            int bitB = (j >= 0) ? b.charAt(j) - '0' : 0;
            
            // Sum the current bits and the carry
            int sum = bitA + bitB + carry;

            // The new carry will be 1 if sum is 2 or 3
            carry = sum / 2;

            // The result bit is sum % 2 (either 0 or 1)
            result.append(sum % 2);

            // Move to the next bits
            i--;
            j--;
        }

        // Since we added bits from right to left, reverse the result
        return result.reverse().toString();
    }
}
