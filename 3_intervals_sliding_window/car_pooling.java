class Solution {
    /*
    [passengers, from, to]

    [3, 0, 7] [4, 3, 6]
    cap = 7
    */

    // Time: O(n * log n)
    // Space: O(n)
    public boolean carPooling(int[][] trips, int capacity) {
        final List<int[]> res = new ArrayList<>();

        // [[4,5,6],[6,4,7],[4,3,5],[2,3,5]]
        for (int i = 0; i < trips.length; i++) {
            int[] trip = trips[i]; // [4,5,6]

            res.add(new int[] {trip[1], trip[0]});
            res.add(new int[] {trip[2], trip[0] * -1});
        }

        Collections.sort(res, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return Integer.compare(a[1], b[1]);
                }
                return Integer.compare(a[0], b[0]);
            }
        });

        int currPass = 0; // 2

        // [5,4] [6,-4] [4,6] [7,-6] [3,4] [5,-4] [3,2] [5,-2]
        // [3,2] [3,4] [4,6]
        for (int i = 0; i < res.size(); i++) {
            int[] ele = res.get(i); // [1,2]
            currPass += ele[1];

            if (currPass > capacity) {
                return false;
            }
        }

        return true;
    }
}