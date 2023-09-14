class Solution {
    /*
        LC example: arr1 = [4,5,8], arr2 = [10,9,1,8], d = 2
    */

    // Time: O(n^2)
    // Space: O(1)
    // public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
    //     int count = 0;

    //     for (int i = 0; i < arr1.length; i++) {
    //         boolean condition = true;
    //         for (int j = 0; j < arr2.length; j++) {
    //             int diff = Math.abs(arr1[i] - arr2[j]);
    //             if (diff <= d) {
    //                 condition = false;
    //                 break;
    //             }
    //         }

    //         if (condition) {
    //             count++;
    //         }
    //     }

    //     return count;
    // }

    // Time: O(?)
    // Space: O(1)
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;

        Arrays.sort(arr2);

        for (int i = 0; i < arr1.length; i++) {
            int left = 0;
            int right = arr2.length - 1;
            boolean condition = true;

            while (left <= right) {
                int idx = left + (right - left) / 2;
                // arr2[idx] in the borders of first ele diff
                if (arr1[i] - d <= arr2[idx] && arr1[i] + d >= arr2[idx]) {
                    condition = false;
                    break;
                }

                if (arr2[idx] > arr1[i]) {
                    right = idx - 1;
                } else {
                    left = idx + 1;
                }
            }

            if (condition) {
                count++;
            }
        }

        return count;
    }
}