class Solution {
    /*
    ["a" * 11, "c"]
    ["r", "r", "a", "c"]
    ["r", "r", "z", "a", "a", "a"]
    ["2r", "z", "3a"]

    {
        "r": 2
        "z": 1
        "a": 3
        "b": 15
    }
    ["r2", "z", "a3", "b", "5"]

    * Skip 1 at all in arr
    */

    // Time: O(n)
    // Space: O(n)
    public int compress(char[] chars) {
        int left = 0;
        int right = 1;

        // no need to make checks afterwards as second while loop will catch end
        while (right < chars.length) {
            while (right < chars.length && chars[right] == chars[right - 1]) {
                right++;
            }

            int diff = right - left;

            chars[left] = chars[right - 1];
            left++;

            if (diff > 1 && diff < 10) {
                // ["r", "r", "z", "a", "a", "a"]
                // ["r", "2"]
                //
                chars[left] = Integer.toString(diff).charAt(0);
                left++;
            } else {
                // means diff >= 10
                int firstNum = diff / 10;
                int secondNum = diff % 10;
                chars[left++] = Integer.toString(firstNum).charAt(0);
                chars[left++] = Integer.toString(secondNum).charAt(0);
            }

            right++;
        }

        return left;
    }

}