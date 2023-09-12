public class Solution {
    public int solve(int[][] A) {
        final List<int[]> nums = new ArrayList<>();

        for (int i = 0; i < A.length; i++) {
            int[] num = A[i]; // [0,30] [5,10] [15,20]
            int[] firstPart = {num[0], 1}; // [0,1], [5,1], [15,1]
            int[] secondPart = {num[1], -1}; // [30,-1], [10,-1], [20,-1]
            nums.add(firstPart);
            nums.add(secondPart);
        }

        nums.sort((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });

        int maxEle = Integer.MIN_VALUE; // 3
        int currEle = 0; // 3

        for (int i = 0; i < nums.size(); i++) {
            int[] num = nums.get(i); // [4,1] [7,1] [10,-1] [13,1] [14,1] [16,1], [16,-1]

            currEle += num[1];
            maxEle = Math.max(currEle, maxEle);
            // if (num[1] == 1) {
            //     currEle++;
            //     maxEle = Math.max(maxEle, currEle);
            // } else {
            //     // num[0] == 0
            //     currEle--;
            // }
        }

        return maxEle;
    }
}
