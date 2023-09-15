class Solution {
    /*
        AABABBA k = 2 -> 5

        * traverse over string and put curr char in map + increase times met
        * length of the curr window - most often met letter. Compare with k.
            - if <= then update
            - else move left pointer

    */
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        final Map<Character, Integer> map = new HashMap<>();
        int longest = 0;

        while (right < s.length()) {
            char currChar = s.charAt(right);
            map.put(currChar, map.getOrDefault(currChar, 0) + 1);

            // at least one value will be present in the map
            int maxValue = map.values().stream().max(Comparator.naturalOrder()).get();
            int diff = (right - left + 1) - maxValue;

            // simple if is enough as algo will work till diff <= k. The moment it breaks - this one gets executed
            if (diff > k) {
                // move left pointer to shrink window aka decrease cardinality
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }

            // only applied for valid substring
            longest = Math.max(longest, right - left + 1);
            right++;
        }

        return longest;
    }
}