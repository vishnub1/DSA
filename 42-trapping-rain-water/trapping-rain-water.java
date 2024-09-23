class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int prefixMax[] = new int[n];
        int suffixMax[] = new int[n];

        int currMax = 0;

        // Prefix Max Right to left 
        for(int i = 0; i < n; i++) {
            if(currMax < height[i]) {
                currMax = height[i];
            }
            prefixMax[i] = currMax;
        }

        // Suffix Max Left to Right 
        currMax = 0;
        for(int i = n-1; i >= 0; i--) {
            if(currMax < height[i]) {
                currMax = height[i];
            }
            suffixMax[i] = currMax;
        }


        // Calculating total water 
        int totalWater = 0;
        for(int i =0 ; i < n; i++) {
            int currWater = Math.min(suffixMax[i], prefixMax[i]) - height[i];
            totalWater += currWater;
        }

        return totalWater;
    }
}