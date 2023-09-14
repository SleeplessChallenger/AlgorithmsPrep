class Solution {
    /*
    [6,2,0,1,5,1,9,1,6,9] - elements of low cardinality in the array

    */

    // Time:
    // Space:
    public int[] sortArray(int[] nums) {
        // create array with range -5 * 10^4 <= nums[i] <= 5 * 10^4
        int offset = 5 * (int) Math.pow(10, 4);
        int[] counts = new int[offset * 2 + 1];

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            counts[num + offset] += 1; // cell depicts number
        }

        final List<Integer> res = new ArrayList<>();

        // initial: [5, 1, 5, 6, 2]
        //            1   2   5
        // count: [...1   1   2]
        for (int i = 0; i < counts.length; i++) {
            int timesMet = counts[i];
            for (int j = 0; j < timesMet; j++) {
                // if 0 times met - won't enter this moment
                res.add(i - offset);
            }
        }

        return res.stream()
                .mapToInt(v -> v)
                .toArray();
    }
}