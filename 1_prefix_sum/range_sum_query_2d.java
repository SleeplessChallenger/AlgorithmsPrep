class NumMatrix {

    /**
     0 0  0  0  0
     1 2 7 4  0 1  3  10 14
     5 0 5 2  0 6  6  19 28
     7 7 8 1  0 13 20 41 51
     1 0 6 3  0

     Calc borders from prefixSum and add value from initial array
     * prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + int[j - 1][j - 1]
     * In arr we used -1 because iteration goes on prefixSum which is bigger in all dimensions by 1
     */

    // UPDATE: 02.09

    // Time: O(n * m)
    // Space: O(n * m)
    private final int[][] prefixSum;

    public NumMatrix(int[][] matrix) {
        prefixSum = new int[matrix.length + 1][matrix[0].length + 1];
        // Java will put 0 by default to int array
        for (int i = 1; i < matrix.length + 1; i++) {
            for (int j = 1; j < matrix[0].length + 1; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1]
                        - prefixSum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    /**
     * row1 & col1 - row and col for left upper
     * row2 & col2 - row and col for right bottom
     */
    public int sumRegion(int row1, int col1, int row2, int col2) {
        // recall that numbers come for initial array size

        return prefixSum[row2 + 1][col2 + 1] + // right bottom
                prefixSum[row1][col1] - // left upper (because subtracted multiple times)
                prefixSum[row1][col2 + 1] - // up from row1
                prefixSum[row2 + 1][col1]; // to the left from row2
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */