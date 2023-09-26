class Solution {
    public int search(int[] nums, int target) {

        int n = nums.length;
        int low = 0, high = n-1;
        int ans = -1; // if not present

        while(low <= high) {
            int mid = (low + high ) /2;

            if(nums[mid] == target) {
                ans = mid; // found the idx
                return ans;  
            } else if (nums[mid] > target) {
                high = mid-1;   // our ele in left part
            } else {
                low = mid + 1; // our ele in right part
            }
        }

        return ans;
    }
}