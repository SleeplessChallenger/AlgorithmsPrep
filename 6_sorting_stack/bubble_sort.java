class Solution {
    /*
    // bubble sort
    [5,2,3,1]

    */

    // Time: O(n^2)
    // Space: O(1)
    public int[] sortArray(int[] nums) {
        int i = nums.length - 1; // 3
        int j = 0; // 0

        // 2 3 1 5
        while (i >= 0) {
            while (j < i) {
                int num1 = nums[j]; // 5
                int num2 = nums[j + 1]; // 2

                if (num1 > num2) {
                    nums[j + 1] = num1;
                    nums[j] = num2;
                }
                j++;
            }

            i -= 1;
            j = 0;
        }

        return nums;
    }
}