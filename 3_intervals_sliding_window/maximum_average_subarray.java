class Solution {
    /*
     * sum first 0 to k - 1 incl -> div 4
     * keep 2 variables: currSum && maxSum
     */

    // Time: O(n)
    // Space: O(1)
    public double findMaxAverage(int[] nums, int k) {
        double currSum = 0.0;
        double maxSum = 0.0;

        // [0,4,0,3,2] k = 1
        for (int i = 0; i < k; i++) {
            currSum += nums[i];
        }

        maxSum = currSum / k;
        int left = 0;

        for (int i = k; i < nums.length; i++) { // 4
            currSum = currSum - nums[left] + nums[i];
            maxSum = Math.max(maxSum, currSum / k);
            left++;
        }

        return maxSum;
    }
}