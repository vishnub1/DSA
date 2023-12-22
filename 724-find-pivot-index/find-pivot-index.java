class Solution {
    public int pivotIndex(int[] nums) {
        int rightSum = 0;
        int leftSum = 0;

        for(int ele : nums) {
            rightSum += ele;   // right sum "TOTAL SUM"
        }

        for(int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];
            if(leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}