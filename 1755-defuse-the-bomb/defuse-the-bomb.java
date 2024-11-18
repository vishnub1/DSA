class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int result[] = new int[n];
        // if k = 0 return the result directly
        if(k == 0) return result; // already filled with 0's

        // Define the initial window and initial sum
        int start = 1, end = k, sum = 0;
       
        //if k < 0, the starting point will be end of the arry
        if(k < 0) {
            start = n - Math.abs(k);
            end = n - 1;
        }

        for(int i = start; i <= end; i++) {
            sum += code[i];  // total sum 
        }
        // scan throught the code array as i moving to the right,
        // update the window sum
        for(int i = 0; i < n; i++) {
            result[i] = sum;
            sum -= code[(start) % n];
            sum += code[(end + 1) % n];
            start++;
            end++;
        }
        return result;
    }
}