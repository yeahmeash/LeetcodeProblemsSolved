class Solution {
    public boolean isSubsequence(String s, String t) {
         if(t.length() < s.length ()) return false;
        int i=0,j=0;
        char [] sChar = s.toCharArray();
        char [] tChar = t.toCharArray();

        while( i < sChar.length && j < tChar.length ){

            if(sChar[i]==tChar[j] ){
                i++;
            }
            j++;
        }

       return i==sChar.length;
    }
}
