/*

Input: "eceba"
Output: 3
Explanation: t is "ece" which its length is 3.

Input: "ccaabbb"
Output: 5
Explanation: t is "aabbb" which its length is 5.

Input: "a"

* keep latest index of the letter.
*/

class Solution {

    // Time: O(n)
    // Space: O(n)
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int left = 0; // 2
        int right = 0; // 4
        int longest = Integer.MIN_VALUE; // 4
        final Map<Character, Integer> map = new HashMap<>(); // for ccaabbb c : 1  { a : 3, b : 6}.

        while (right < s.length()) {
            char currChar = s.charAt(right); // b

            while (map.size() == 2 && !map.containsKey(currChar)) {
                char leftChar = s.charAt(left); // c
                if (map.get(leftChar) == left) {
                    map.remove(leftChar);
                }
                left++;
            }

            map.put(currChar, right);
            longest = Math.max(longest, right - left + 1);
            right++;
        }

        return longest;
    }
}
