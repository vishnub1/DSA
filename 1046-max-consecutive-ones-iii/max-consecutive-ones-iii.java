class Solution {
    public int longestOnes(int[] nums, int k) {
        int zeroCount = 0;
        int start = 0;
        int maxlen = 0; 

        // 2 pointer approach 
        for(int end = 0; end < nums.length; end++) {
            if(nums[end] == 0) {
                zeroCount++;
            }
            while(zeroCount > k) {    // Windo shrinking
                if(nums[start] == 0) {
                    zeroCount--;
                }
                start++;  // Shrinking
            }
            maxlen = Math.max(maxlen, end - start + 1);
        }

        return maxlen;
    }
}