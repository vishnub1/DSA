class Solution {
    public int searchInsert(int[] nums, int target) {

        int n = nums.length;

        int low = 0; 
        int high = n-1;
        int ans = n;

        while(low <= high) {
            int mid = (low + high) / 2;
            if(nums[mid] >= target) {
                ans = mid;  // may be the ans
                high = mid - 1;   // but search for the smaller index
            } else {  // arr[mid] < x    // in this case search in righ part
                low = mid + 1;
            }
        }
        return ans;
    }
}