class Solution {
    public void moveZeroes(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) count++;
        }
        
        //push all non zero 
        int idx = 0;
        for(int i =0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[idx] = nums[i];
                idx++;
            }
        }

        // pushing zeros
        for(int i =0; i < count; i++) {
            nums[idx] = 0;
            idx++;
        }
    }
}