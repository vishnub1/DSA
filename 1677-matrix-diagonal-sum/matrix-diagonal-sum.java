class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat[0].length;

        int sum = 0;
        int primaryDiagonalSum = 0;
        int secondaryDiagonalSum = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) {
                    primaryDiagonalSum += mat[i][j];
                }        
            }
        }
                    // System.out.println(primaryDiagonalSum);


        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i+j == n-1) {
                    secondaryDiagonalSum += mat[i][j];
                    
                }       
            }
        }

        // System.out.println(secondaryDiagonalSum);

        // for odd n size matrix
        int idx = n / 2;
        if(n % 2 == 0) {
            sum = primaryDiagonalSum + secondaryDiagonalSum;
        } else {
            sum = primaryDiagonalSum + secondaryDiagonalSum - mat[idx][idx];
        }

        return sum;
    }
}