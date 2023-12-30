class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {

        int result[] = new int[queries.length];

        // prefix sum of XOR
        int prefXOR[] = new int[arr.length];
        prefXOR[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefXOR[i] = arr[i] ^ prefXOR[i - 1];
        }

        // now solving queries
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            if (l == 0) {   // if left is 0 then pref is till r is the sum of that subarray obviously
                result[i] = prefXOR[r];
            } else {
                result[i] = prefXOR[r] ^ prefXOR[l - 1];
            }
        }

        return result;
    }
}