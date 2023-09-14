class Solution {
    /*
    [1, 2, 2, -1, 4, 0, 8] k = 5
    [1, 2, 2]
    [2, -1, 4]

    UPDATE: 02.09
       0   1    3      6
    -------------------------->
       1

    6 6 5 3 3 => 3, not 3
    0 0 1 2 3

    (currSum - k) - if such num exists in pxSum, then it get count it appeared
    Because we subtract (currSum - k) where k - target
    */

    // Time: O(n)
    // Space: O(n)
    public int subarraySum(int[] nums, int k) {
        final Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int count = 0;
        int currSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            if (map.containsKey(currSum - k)) {
                count += map.get(currSum - k);
            }

            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }

        return count;
    }
}