class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;

        HashSet<Integer> set = new HashSet<>(); 

        int start = 0;
        int end = 0;

        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        while(end < n) {
            
            if(!set.contains(nums[end])) {
                currSum += nums[end];
                maxSum = Math.max(maxSum, currSum);
                set.add(nums[end]);
                end++;
            } else {  
                currSum = currSum - nums[start];  // minus first element 
                set.remove(nums[start]);  // remove from start pointer
                start++;
            }
        }
        
        return maxSum;
    }
}