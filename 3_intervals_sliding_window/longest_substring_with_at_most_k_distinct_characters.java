/*
Input: s = "eceba", k = 2
Output: 3
Explanation: T is "ece" which its length is 3.


Input: s = "aa", k = 1
Output: 2
Explanation: T is "aa" which its length is 2.

1 <= s.length <= 5 * 10^4
0 <= k <= 50

*/

class Solution {

    // Time: O(n)
    // Space: O(n)
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int longest = Integer.MIN_VALUE;
        final Map<Character, Integer> map = new HashMap<>();

        while (right < s.length()) {
            char currChar = s.charAt(right);

            while (map.size() == k && !map.containsKey(currChar)) {
                char leftChar = s.charAt(left);
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