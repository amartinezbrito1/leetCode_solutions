/*



To understand this, the very first thing you need to know is that what is the difference between substring and subsequence

substring is a continuous part or subpart of a string

whereas

subsequence is the part of a string or sequence, that might be continuous or not but the order of the elements is maintained

For example, let's say we have the following strings:

str_a="hello there"
str_b="hello"
str_c="ello th"
str_d="hllo"
str_e="ho hre"
str_f="there hello"

str_b is a substring of str_a, str_c is also a substring of str_a but str_d is not a substring of str_a as this substring is not continuous.

Now all substrings are subsequences as the order is maintained.

str_d is a subsequence of str_a, str_e is also a subsequence of str_a however str_f is not a subsequence of str_a as in this case the order is not maintained.

Now for java, there is no appropriate clarification regarding these methods in javadoc.

*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        //map to store the last seen position of each character
        //raw hashmap --not specifying the type 
        Map charMap = new HashMap<>();
        int maxLength = 0;  // Length of the longest substring without repeating characters
        int start = 0;      // Start of the current window

        for (int end = 0; end < s.length(); end++) {
            //check the value (char) for the string "s" at index "end" and store it on currentChar
            char currentChar = s.charAt(end);
            
            // If the character is already in the window, move the start of the window
            if (charMap.containsKey(currentChar)) {
                // Move start to the right of the last occurrence of the character or keep it if already past that point
                start = Math.max((int)charMap.get(currentChar) + 1, start);
            }
            
            // Update the last seen position of the character
            charMap.put(currentChar, end);
            
            // Update maxLength if the current window is larger
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb")); 
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));    
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));   
    }
}
