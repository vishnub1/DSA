class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int[] oneD = new int[n*n];  // Converting it into 1D array 
        int idx = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                oneD[idx] = matrix[i][j];
                idx++;
            }
        }

        Arrays.sort(oneD); // sort 
        return oneD[k - 1]; // return 
    }
}