class Solution {
    public boolean canJump(int[] nums) {
        // Initially the final position is the last index
        int finalPosition = nums.length-1;

        // start with the second last index
        for(int i = nums.length-2; i >= 0; i--) {
            // If you can reach the final position from this index
            // update the final position flag
            if(i + nums[i] >= finalPosition) {
                finalPosition = i;
            }
        }   
        
        // If we reach the first index, the we can make the jump possible
        return finalPosition == 0;
    }
}