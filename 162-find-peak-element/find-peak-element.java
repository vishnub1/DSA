class Solution {
    public int findPeakElement(int[] nums) {

        int n = nums.length;

        // edge case
        if(n == 1) return 0;
        if(nums[0] > nums[1]) return 0;  //first index is greater
        if(nums[n-1] > nums[n-2]) return n-1; // think the logic

        // we handle the first and last element saperately
        // now handle the middle elements
        int low = 1, high = n-2;
        while(low <= high) {
            int mid = (low + high) / 2;

            // if arr[mid] is peak
            if(nums[mid-1] < nums[mid] && nums[mid] > nums[mid+1]) {
                return mid;
            }

            // if we are in the left 
            if(nums[mid] > nums[mid-1]){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        // dummy return statement 
        return -1;
    }
}