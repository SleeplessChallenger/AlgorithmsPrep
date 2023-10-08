class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void quickSort(int[] nums, int i, int j) {
        if (i < j) {
            int pivotIdx = partition(nums, i, j);
            quickSort(nums, i, pivotIdx - 1);
            quickSort(nums, pivotIdx + 1, j);
        }
    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (i < j && nums[i] <= pivot) {
                // greater than pivot => stop
                i++;
            }

            while (nums[j] > pivot) {
                // smaller than pivot => stop
                j--;
            }

            if (i < j) {
                // they must not intersect
                swap(i, j, nums);
            }
        }

        swap(low, j, nums); // swap pivotIdx with j
        return j;
    }

    private static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}