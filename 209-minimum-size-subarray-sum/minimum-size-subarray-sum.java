class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int left = 0;
        int prefSum = 0;

        for(int i=0; i<nums.length; i++) {
            prefSum += nums[i];

            while(prefSum >= target) {
                result = Math.min(result, i - left + 1);
                prefSum -= nums[left];  // removing from front and chech min size array 
                left++;
            } 
        }
        //  If there is no such subarray, return 0 instead. 
        return (result == Integer.MAX_VALUE) ? 0 : result;
    }
}