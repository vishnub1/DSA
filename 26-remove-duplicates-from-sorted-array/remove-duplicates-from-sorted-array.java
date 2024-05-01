class Solution {
    public int removeDuplicates(int[] nums) {
        // using to pointer approach

        int i = 0; // pointer1
        
        for(int j = 1; j < nums.length; j++) {
            if(nums[j] != nums[i]) {
                i++;
                nums[i]  = nums[j];
            }
        }

        return i + 1;

    }
}