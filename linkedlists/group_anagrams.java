class Solution {
    /*
    ["eat","tea","tan","ate","nat","bat"]

    * keep hashtable of sorted words as keys and values - curr value
    * finally return values as list

    */

    // Time: O(n * log k)
    // Space: O(n)
    public List<List<String>> groupAnagrams(String[] strs) {
        final Map<String, List<String>> map = new HashMap<>();

        // loop: O(n)
        for (int i = 0; i < strs.length; i++) {
            String currString = strs[i]; // bat
            String sortedString = sortString(currString); // abt
            if (!map.containsKey(sortedString)) {
                map.put(sortedString, new ArrayList<>());
                /*
                {
                    aet: [eat, tea, aet]
                    ant: [tan, nat]
                    abt: [bat]
                }
                */
            }

            map.get(sortedString).add(currString);
        }

        return map.values().stream().toList();
    }

    // sort: O(n*log k)
    private static String sortString(String str) {
        char[] array = str.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }

}