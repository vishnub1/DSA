class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int[] result = new int[2];
        int row = mat.length; // number of rows
        int col = mat[0].length; // number of columns

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // Check if the current element is a peak by comparing with its neighbors
                if (isPeak(mat, i, j, row, col)) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }

        return result;
    }

    // Helper function to check if the current element is a peak
    private boolean isPeak(int[][] mat, int i, int j, int row, int col) {
        int current = mat[i][j];

        if (j > 0 && mat[i][j - 1] > current) {  // checking UP
            return false;
        }
        if (j < col - 1 && mat[i][j + 1] > current) { // checking Down 
            return false;
        }
        if (i > 0 && mat[i - 1][j] > current) { // checking LEFT
            return false;
        }
        if (i < row - 1 && mat[i + 1][j] > current) {  // checking RIGHT
            return false;
        }
        return true;
    }
}
