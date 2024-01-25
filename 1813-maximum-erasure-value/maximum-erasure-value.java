class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;

        HashMap<Integer, Integer> set = new HashMap<>();

        int start = 0;
        int end = 0;

        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        while(end < n) {
            
            if(!set.containsKey(nums[end])) {
                currSum += nums[end];
                maxSum = Math.max(maxSum, currSum);
                set.put(nums[end], 1);
                end++;
            } else {
                if(set.get(nums[start]) > 0) {
                    set.put(nums[start], set.get(nums[start]) - 1);
                }

                if(set.get(nums[start]) == 0) {
                    set.remove(nums[start]);
                }
                
                currSum = currSum - nums[start];
                start++;
                
            }

        }
        
        return maxSum;
    }
}