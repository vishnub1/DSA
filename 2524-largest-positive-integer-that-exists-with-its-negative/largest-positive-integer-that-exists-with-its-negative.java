class Solution {
    public int findMaxK(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        for(int i : nums) {
            System.out.print(i + " ");
        }
        int start = 0;
        int end = n-1;
        
        while(start < end) {
            if((Math.abs(nums[start]) == Math.abs(nums[end])) && (nums[start] != nums[end])) {
                return Math.abs(nums[end]);
            } else if(Math.abs(nums[start]) < Math.abs(nums[end])) {
                end--;
            } else {
                start++;
            }
        }
        return -1;
    }
}