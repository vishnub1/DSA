class Solution {
    public int search(int[] nums, int target) {

        int low = 0, high = nums.length-1;
        int ans = -1;

        while(low <= high) {
            int mid = low + ((high - low) /2);
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] >= nums[low]) { // left part is sorted
                if(nums[low] <= target && nums[mid] >= target) {  // remove the right part 
                    high = mid-1;
                } else {
                    low = mid + 1;
                }
            } else {  // right part is sorted
                if(nums[mid] <= target && nums[high] >= target) {
                    low = mid + 1;
                } else {
                    high = mid -1;
                }
            }
        }
        return ans;
    }
}