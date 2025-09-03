class Solution {
public String decodeString(String s) {
    Stack<Integer> countStack = new Stack<>();   // stores repeat counts
    Stack<StringBuilder> strStack = new Stack<>(); // stores previous strings
    StringBuilder curr = new StringBuilder();   // current substring
    int num = 0;

    for (char ch : s.toCharArray()) {
        if (Character.isDigit(ch)) {
            num = num * 10 + (ch - '0'); // build full number (like "12")
        } 
        else if (ch == '[') {
            countStack.push(num);      // save number
            strStack.push(curr);       // save current string
            curr = new StringBuilder();// reset for new substring
            num = 0;                   // reset number
        } 
        else if (ch == ']') {
            int repeat = countStack.pop(); // get repeat count
            StringBuilder prev = strStack.pop(); // get prev string
            // append repeated substring to previous string
            curr = prev.append(curr.toString().repeat(repeat));
        } 
        else {
            curr.append(ch); // normal character
        }
    }
    return curr.toString();
}

}