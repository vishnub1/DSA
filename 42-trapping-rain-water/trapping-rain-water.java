class Solution {
    public int trap(int[] height) {
        int n  = height.length;

        // STEP 1 Make a prefix array maximum 
        int maximumTillNow = 0;
        int prefixMax[] = new int[n];

		for(int i = 0; i < n; i++) {
			if(height[i] > maximumTillNow) {
				maximumTillNow = height[i];
			}
			prefixMax[i] = maximumTillNow;
		}

        // STEP 2 Prefix Maximun () maximum so far
		maximumTillNow = 0;
		int suffixMax[] = new int[n];
		for(int i = n-1; i >= 0; i--) {
			if(height[i] > maximumTillNow) {
				maximumTillNow = height[i];
			}
			suffixMax[i] = maximumTillNow;
		}

        // STEP3 Find WATER 
		int totalWater = 0;
		for(int i = 0; i < n; i++) {
			int currWater = Math.min(suffixMax[i], prefixMax[i]) - height[i];
			totalWater += currWater;
		}
        return totalWater;
    }
}