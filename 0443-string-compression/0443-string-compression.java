class Solution {
    public int compress(char[] chars) {
        int index = 0; // index to write to
        int i = 0;     // pointer to read

        while (i < chars.length) {
            char currentChar = chars[i];
            int count = 0;

            // Count how many times currentChar repeats
            while (i < chars.length && chars[i] == currentChar) {
                i++;
                count++;
            }

            // Write the character
            chars[index++] = currentChar;

            // Write the count if more than 1
            if (count > 1) {
                String countStr = Integer.toString(count);
                for (char c : countStr.toCharArray()) {
                    chars[index++] = c;
                }
            }
        }

        return index;
    }
}
