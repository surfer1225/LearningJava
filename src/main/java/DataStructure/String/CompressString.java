package main.java.DataStructure.String;

/*
443. String Compression

Given an array of characters, compress it in-place.

The length after compression must always be smaller than or equal to the original array.

Every element of the array should be a character (not int) of length 1.

After you are done modifying the input array in-place, return the new length of the array.


Follow up:
Could you solve it using only O(1) extra space?


Example 1:

Input:
["a","a","b","b","c","c","c"]

Output:
Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]

Explanation:
"aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".

 */

public class CompressString {
    public int compress(char[] chars) {
        int idx = 0;
        int n = chars.length;
        int start = 0;

        while (idx < n) {
            char c = chars[idx];
            int count = 0;
            while (idx < n && chars[idx] == c) {
                idx++;
                count++;
            }

            chars[start++] = c;

            if (count > 1) {
                char[] digits = String.valueOf(count).toCharArray();
                for (char digit : digits) {
                    chars[start++] = digit;
                }
            }
        }

        return start;
    }

    /*
    public int compress(char[] chars) {
        int anchor = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    for (char c: ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return write;
    }
     */
}
