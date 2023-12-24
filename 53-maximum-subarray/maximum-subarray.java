class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for(int i = 0; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);  // curr sum will choose to start a new train or sit with previous train and amplify its value 
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}