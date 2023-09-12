class Solution {

    // Time: O(n * logn)
    // Space: O(n)
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        final List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            int[] prev = result.get(result.size() - 1);

            if (curr[0] <= prev[1]) {
                prev[0] = Math.min(prev[0], curr[0]);
                prev[1] = Math.max(prev[1], curr[1]);
            } else {
                result.add(curr);
            }
        }

        return result.stream().toArray(int[][]::new);
    }
}