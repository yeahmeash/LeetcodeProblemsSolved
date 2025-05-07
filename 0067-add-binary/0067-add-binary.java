class Solution {
    public String addBinary(String a, String b) {
        
        if(a.length() > b.length()){
            return addBinary(b, a);
        }        
        int i = a.length() - 1;
        int j = b.length() - 1;
        char[] result = new char[b.length() + 1];
        int k = b.length();
        int sum = 0;
        int carry = 0;

        while(j >= 0){
            int ch_a = i >= 0 ? a.charAt(i--) - '0' : 0;
            int ch_b = b.charAt(j) - '0';

            sum = ch_a + ch_b + carry;
            int res = sum % 2;
            carry = sum / 2;
            result[j + 1] = (char)(res + '0');
            j--;

        }
        if(carry == 0) return new String(result , 1 , result.length-1);

        result[0] = '1';
        return new String(result);
    }

}
