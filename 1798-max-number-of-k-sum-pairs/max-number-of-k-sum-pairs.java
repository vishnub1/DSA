class Solution {
    public int maxOperations(int[] nums, int k) {
        // Using 2 Pointer Approach   // TC - O(nlongn) sc = O(1)
        Arrays.sort(nums);
        int n = nums.length;
        int count = 0;
        int start = 0;
        int end = n-1;

        while(start < end) {
            int sum = nums[start] + nums[end];
            if(sum == k) {
                count++;
                start++;
                end--;
            } else if(sum > k) {
                end--;
            } else { // (sum < k)
                start++;
            }
        }

        return count;
    }
}