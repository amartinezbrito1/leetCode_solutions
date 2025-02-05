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
        //specify the kind of Map you will use, in this case not a raw map, but specific one <char,int>
 Map<Character, Integer> storage = new HashMap<>();
 int maxLenght = 0;
 int start = 0;

//itirate thru the string by using a window (sliding window algorithm)
for (int end=0;end < s.length(); end++)
{
    //what we need is a char and that is our point of reference
char currentChar = s.charAt(end);

//check if we have a duplicate and have seen the current char before, if empty just skip
if (storage.containsKey(currentChar))
{
    //move the start pointer to the last time "  [index] + 1 " you saw that char
    //you shouldnt move i (start) pointer if it is not inside your current window 
    start = Math.max(start, storage.get(currentChar) + 1);
}
//populating the storgare map
storage.put(currentChar,end);
//update the lenght of the current iteration only if greater than the previous (already stored lenght)
maxLenght = Math.max(maxLenght, end - start + 1);


}
return maxLenght;

    }

    // Main method for testing
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb")); 
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));    
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));   
    }
}
