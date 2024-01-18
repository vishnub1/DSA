class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        
        // Calculate the sum of the first k elements
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        
        // Initialize maxAvg with the average of the first window
        double maxAvg = sum / (double) k;
        
        // Slide the window through the array and update maxAvg
        for (int i = k; i < n; i++) {
            sum += nums[i] - nums[i - k]; // Update sum by adding the next element and removing the first element of the window
            maxAvg = Math.max(maxAvg, sum / (double) k);
        }
        
        return maxAvg;
    }
}
