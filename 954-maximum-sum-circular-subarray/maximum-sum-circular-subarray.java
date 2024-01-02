class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currMax  = 0;
        int maxSumSubarray = Integer.MIN_VALUE;

        int currMin = 0;
        int minSumSubarray = Integer.MAX_VALUE;

        int total = 0;

        for(int i = 0; i < nums.length; i++) {
            total += nums[i];

            // Calculating maxSumSubarray 
            currMax = Math.max(nums[i], currMax + nums[i]);
            maxSumSubarray = Math.max(maxSumSubarray, currMax);

            // Calculating minSumSubarray 
            currMin = Math.min(nums[i], currMin + nums[i]);
            minSumSubarray = Math.min(minSumSubarray, currMin);
        }

        // If All are -ve 
        if(total == minSumSubarray) {
            return maxSumSubarray;
        }

        return Math.max(maxSumSubarray, total - minSumSubarray);
    }
}