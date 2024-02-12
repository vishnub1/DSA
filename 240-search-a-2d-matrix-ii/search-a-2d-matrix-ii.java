class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int m = mat.length;  // row size
        int n = mat[0].length;  // col size   [m*n]

        int row = 0;
        int col = n-1;
        // start searching from top right corner 

        while(row < m && col >= 0) {
            if(mat[row][col] == target) {
                return true;
            }

            if(mat[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }

        return false;
    }
}