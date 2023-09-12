class Solution {
    /*
    abcea_dbhj_bl (second a will fail if don't use max())

    * can be 0 length
    * pwwkew - here we need to take MAX from the map
    * abba - here we need to take MAX from the left
    * tm_mzuxt
    */

    // Time: O(n)
    // Space: O(n)
    public int lengthOfLongestSubstring(String s) {
        final Map<Character, Integer> map = new HashMap<>();
        int left = 0; // 0
        int maxSequence = 0; // 0

        for (int i = 0; i < s.length(); i++) { // 2
            char letter = s.charAt(i); //
            if (map.containsKey(letter)) {
                left = Math.max(left, map.get(letter) + 1); // left ALREADY on another character. Like in abba. Second a meets when we switched LEFT to b
                // abcd_ber. Not simply move left, but get max from map
                /*
                    {
                        a: 0
                        b: 1
                    }

                */
            }

            maxSequence = Math.max(maxSequence, i - left + 1);
            map.put(letter, i);
        }

        return maxSequence;
    }
}