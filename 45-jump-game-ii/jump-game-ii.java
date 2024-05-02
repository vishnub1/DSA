class Solution {
    public int jump(int[] nums) {
        int totalJumps = 0;

        // destinaton is last index
        int destination = nums.length-1;

        int coverage = 0, lastJumpIdx = 0;

        // Base case
        if(nums.length == 1) return 0;

        // Greedy stratey : extend coverage as long as possible
        for(int i = 0; i < nums.length; i++) {
            coverage = Math.max(coverage, i+nums[i]);

            if(i == lastJumpIdx) {
                lastJumpIdx = coverage;
                totalJumps++;

                // check if er reached destination already  
                if(coverage >= destination) {
                    return totalJumps;
                }
            }
        }

        return totalJumps;
    }
}