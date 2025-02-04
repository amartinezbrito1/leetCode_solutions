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

