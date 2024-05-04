class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int row = mat.length;
        int col = mat[0].length;
        if(row * col != r * c) return mat;

        int result[][] = new int[r][c];
        int row_num = 0;
        int col_num = 0;  // ans array

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                result[row_num][col_num] = mat[i][j];
                col_num++;
                if(col_num == c) {
                    col_num = 0;
                    row_num++;
                }
            }
        }
        return result;
    }
}