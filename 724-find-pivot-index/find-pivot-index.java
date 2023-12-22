class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;

        // Calculate the prefix sum array
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = nums[i] + prefixSum[i - 1];
        }

        // Calculate the reverse prefix sum array
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = nums[i] + suffixSum[i + 1];
        }

        // Finding the pivot
        for (int i = 0; i < n; i++) {
            if (prefixSum[i] == suffixSum[i]) {
                return i; // Pivot found
            }
        }

        return -1; // Pivot not found
        
    }
}