class Solution {
    /*
    s = "anagram", t = "nagaram" - true

    s = "rat", t = "car" - false

    s = "rrr" t = "rra"

    * use hashtable: put all letters from first
    * start traverse over second: if letter not in ht || count == 0 => false else subtract
    * finally check that hashtable is empty TODO: check if needed as we already cut cases with diff in lengths
    */

    // Time: O(n)
    // Space: O(n)
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        final Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i); // a
            map.put(currChar, map.getOrDefault(currChar, 0) + 1);
            /*
            {
                a : 3
                n : 1
                g : 1
                r : 1
                m : 1
            }
            */
        }

        for (int i = 0; i < t.length(); i++) {
            char currChar = t.charAt(i);
            if (!map.containsKey(currChar) || map.get(currChar) == 0) {
                return false;
            }
            map.put(currChar, map.get(currChar) - 1);
        }

        return true;
    }
}