class Solution {
    /*
     * traverse over nums with right
     * check whether curr ele is 0 or not
     * if zeroCount > 1 -> move left pointer
     * increase curr max window
     *
     */

    // Time: O(n)
    // Space: O(1)
    public int longestSubarray(int[] nums) {
        // [1,1,0,1]
        // [0,1,1,1,0,1,1,0,1]
        // [1,1,1]
        // [0,0,0,1,1,0]
        int left = 0; // 0
        int right = 0; // 3
        int maxLength = Integer.MIN_VALUE; // 3
        int zeroesCount = 0; // 1

        while (right < nums.length) {
            if (nums[right] == 0) {
                zeroesCount++;
            }

            while (zeroesCount > 1) {
                zeroesCount -= (nums[left] == 0) ? 1 : 0;
                left++;
            }

            maxLength = Math.max(maxLength, right - left);
            right++;
        }

        return maxLength;
    }
}