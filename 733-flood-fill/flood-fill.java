class Solution {

    //DSF 
    public void dfs(int[][] ans, int row, int col, int[][] image, 
            int newColor, int[] delRow, int[] delCol, int iniColor) {

        // coloring 
        ans[row][col] = newColor;
        int n = image.length;
        int m = image[0].length;

        for(int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && 
            image[nrow][ncol] == iniColor  && ans[nrow][ncol] != newColor) {
                dfs(ans, nrow, ncol, image, newColor, delRow, delCol, iniColor);
            }
        }

    }


    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int iniColor = image[sr][sc];  // initial color
        int [][] ans = image; // copy 

        //{L, R, U, D}
        int delRow[] = {0, 0, -1, 1};
        int delCol[] = {-1, 1, 0, 0};

        dfs(ans, sr, sc, image, color, delRow, delCol, iniColor);

        return ans;
    }
}