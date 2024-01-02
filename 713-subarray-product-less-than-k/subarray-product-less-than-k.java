class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int start= 0;
        int end = 0;
        int currProduct = 1;
        int count = 0;

        while(end < n) {
            currProduct = currProduct * nums[end];

            while(start<= end && currProduct >= k) {  
                currProduct = currProduct / nums[start]; // removing ele from starting so that product is in range
                start++;
            }

            // counting 
            if(currProduct < k ){
                count += end - start + 1;
            }
            end++;
        }

        return count;
    }
}