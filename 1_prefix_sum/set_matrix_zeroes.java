class Solution {

    public void setZeroes(int[][] matrix) {
        // 1. find if there are any 0's in the first row or col
        boolean firstRowZero = false;
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                firstRowZero = true;
                break;
            }
        }

        boolean firstColZero = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // 2. traverse matrix except for first row or col. Set 0 for the first row || col
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                // it will serve as a SIGNAL for the next loop that this row/col must be zero
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 3. Go over again and if PREV STEP set 0 in the first row or col - set it as well
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                // the whole row/col lines become of zeros.
                // IMPORTANT: both checks are crucial. Without [0][j] - only rows updated,
                // without [i][0] - only rows
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 4. set first row and col to 0 - BECAUSE WE SET ONLY LINES IN ROWS/COLS, NOT THE WHOLE ROW
        if (firstRowZero) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

        if (firstColZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

    }


    /*
    * M * N - size of rows can DIFFER from size of cols
    * iterate with 2 loops
    * if 0 -> put on stack and go in 4 directions. In such a way it can expand to borders

     [[1,1,1],    [[1,0,1],
      [1,0,1],      [0,0,0],
      [1,1,1]]      [1,0,1]]


      [[1,1,1],
       [1,0,1],
       [1,1,1],
       [1,1,1]]


       [[0,1,2,0],[3,4,5,2],[1,3,1,5]]

    */
    // public void setZeroes(int[][] matrix) {
    //     final Set<Pair<Integer, Integer>> visited = new HashSet<>();

    //     for (int i = 0; i < matrix.length; i++) {
    //         for (int j = 0; j < matrix[0].length; j++) {
    //             int cell = matrix[i][j];
    //             if (cell != 0) {
    //                 continue;
    //             }
    //             traverseMatrix(matrix, i, j, visited); // 1,1
    //         }
    //     }
    // }

    // private static void traverseMatrix(int[][] matrix, int row, int col, Set<Pair<Integer, Integer>> visited) {
    //     final Queue<Pair<Integer, Integer>> stack = new ArrayDeque<>();
    //     stack.add(new Pair<>(row, col));

    //     while (!stack.isEmpty()) {
    //         Pair<Integer, Integer> pair = stack.poll();
    //         Integer newRow = pair.getKey();
    //         Integer newCol = pair.getValue();

    //         if (visited.contains(pair)) {
    //             continue;
    //         }

    //         // set 0
    //         matrix[newRow][newCol] = 0;

    //         // add to visited to prevent cycles
    //         visited.add(pair);

    //         // explore nearby cells
    //         explore(matrix, newRow, newCol, stack);
    //     }
    // }

    // private static void explore(int[][] matrix, int row, int col, Queue<Pair<Integer, Integer>> stack) {
    //     if (row > 0 && matrix[row - 1][col] != 0) {
    //         stack.add(new Pair<>(row - 1, col));
    //     }
    //     if (col > 0 && matrix[row][col - 1] != 0) {
    //         stack.add(new Pair<>(row, col - 1));
    //     }
    //     if (row < matrix.length - 1 && matrix[row + 1][col] != 0) {
    //         stack.add(new Pair<>(row + 1, col));
    //     }
    //     if (col < matrix[0].length - 1 && matrix[row][col + 1] != 0) {
    //         stack.add(new Pair<>(row, col + 1));
    //     }
    // }

}
