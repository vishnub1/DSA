class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n-1); // full reverse
        reverse(nums, 0, k-1); // reverse till k 
        reverse(nums, k, n-1); // reverse from k
    }

    public void reverse(int[] nums, int start, int end){
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}




