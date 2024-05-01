class Solution {
    public int removeElement(int[] nums, int val) {
        
        int ansPointer = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[ansPointer] = nums[i];
                ansPointer++;
            }
        }

        return ansPointer;
    }
}