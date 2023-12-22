class Solution {
    public int maxSubArray(int[] nums) {
        // edge case
        int n = nums.length;
        if(n == 1) return nums[0];

        int maxSum = nums[0];  // ans
        int train = nums[0];   // previous sum 

        ///////// kadane's algorithm//////////
        for(int i = 1; i < nums.length; i++) {
            train = Math.max(nums[i], train + nums[i]);   // curr element will always wants to amplify 
            maxSum = Math.max(maxSum, train);
        }
        return maxSum;
    }
}