class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        // soting 
        Arrays.sort(nums);

        // edge case
        if(n==1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[n-1] != nums[n-2]) return nums[n-1];

        for(int i = 1; i < n-2; i = i+3) {
            if(nums[i] != nums[i-1]) {
                return nums[i-1];
            } else if(nums[i] != nums[i+1]) {
                return nums[i+1];
            }
        }

        return -1;// dummy 
    }
}