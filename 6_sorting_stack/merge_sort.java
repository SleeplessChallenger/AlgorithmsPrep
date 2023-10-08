class Solution {
    /*
    Use merge sort to sort array
    */

    // Time: O(n * log n)
    // Space: O(n)
    public int[] sortArray(int[] nums) {
        divide(nums, 0, nums.length - 1);
        return nums;
    }

    // divide
    private static void divide(int[] nums, int left, int right) {
        // [5,2,3,1]
        if (left == right) {
            return;
        }

        int mid = left + (right - left) / 2; // 2
        divide(nums, left, mid); // 0 1
        divide(nums, mid + 1, right); // 2 3
        conquer(nums, left, right, mid);
    }


    // conquer
    private static void conquer(int[] nums, int left, int right, int mid) {
        int first = left;
        int second = mid + 1;
        int idx = 0;
        int[] res = new int[right - left + 1]; // range between 2 indicies

        while (first <= mid && second <= right) {
            // <= because inclusive
            int num1 = nums[first];
            int num2 = nums[second];

            if (num1 > num2) {
                res[idx] = num2;
                second++;
            } else {
                res[idx] = num1;
                first++;
            }
            idx++;
        }

        while (first <= mid) {
            res[idx] = nums[first];
            first++;
            idx++;
        }

        while (second <= right) {
            res[idx] = nums[second];
            second++;
            idx++;
        }

        int finalIdx = left;
        for (int i = 0; i < res.length; i++) {
            nums[finalIdx] = res[i];
            finalIdx++;
        }
    }

}