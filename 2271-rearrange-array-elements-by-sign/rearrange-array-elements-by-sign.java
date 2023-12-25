class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];

        int posIndex = 0, negIndex = 1;

        for(int i = 0; i < n; i++) {
            if(nums[i] > 0) {  // number is +ve
                ans[posIndex] = nums[i];
                posIndex += 2;
            } else {  // number is -ve 
                ans[negIndex] = nums[i];
                negIndex += 2;
            }
        }
        
        return ans;
    }
}