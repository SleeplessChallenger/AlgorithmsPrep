class Solution {
    /*
    "aa" - 0
    "abca" - 2
    "cbzxy" - -1

    "a_fga_nnow_a" - 7
    */

    // Time: O(n)
    // Space: O(n)
    public int maxLengthBetweenEqualCharacters(String s) {
        final Map<Character, Integer> map = new HashMap<>(); // { a : 0 f : 1 g : 2}
        int longest = -1;

        for (int i = 0; i < s.length(); i++) { // 3
            char currChar = s.charAt(i); //
            if (map.containsKey(currChar)) {
                longest = Math.max(longest, i - map.get(currChar) - 1);
            }

            if (!map.containsKey(currChar)) {
                map.put(currChar, i);
            }
        }

        return longest;
    }
}