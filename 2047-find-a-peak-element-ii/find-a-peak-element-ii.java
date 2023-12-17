class Solution {
    // maxInCol
    public int maxInCol(int mat[][], int n, int m, int col) {
        int maxVal = Integer.MIN_VALUE;
        int row = -1;
        for(int i = 0; i < n; i++) {  // checking vertically
            if(mat[i][col] > maxVal) {
                maxVal = mat[i][col];
                row = i;
            }
        }
        return row;
    }

    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;   // row 
        int m = mat[0].length;  // col

        int low = 0; 
        int high = m - 1;

        while(low <= high) {
            int mid = (low + high) / 2;
            int row = maxInCol(mat, n, m, mid);  // max in col(mid value col) then will get max row index

            int left = mid > 0 ? mat[row][mid-1] : -1; 
            int right = mid < m-1 ? mat[row][mid+1] : -1;

            if(mat[row][mid] > left && mat[row][mid] > right) {
                return new int[]{row, mid};
            } else if (mat[row][mid] < left) {  // eleminate right part
                high = mid - 1;
            } else {   // mat[row][mid] < right)
                low = mid + 1;
            }
        }
        // dummy return if peak not found
        return new int[]{-1, -1};
    }
}