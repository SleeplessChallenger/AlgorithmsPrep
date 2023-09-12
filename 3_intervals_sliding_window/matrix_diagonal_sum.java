class Solution {
    /*
    [ [1,1],
      [1,1]
    ]
    */

    // Time: O(n)
    // Space: O(1)
    public int diagonalSum(int[][] mat) {
        int sum = 0; // + 1 + 3 | + 5 + 5 | + 9 + 7

        for (int i = 0; i < mat.length; i++) {
            sum += mat[i][i];

            if (i == mat.length - 1 - i) {
                // pass adding the second diagonal when length is not even
                continue;
            }

            sum += mat[i][mat.length - 1 - i];
        }

        // if (mat.length % 2 != 0) {
        //     sum -= mat[mat.length / 2][mat.length / 2];
        // }

        return sum;
    }
}