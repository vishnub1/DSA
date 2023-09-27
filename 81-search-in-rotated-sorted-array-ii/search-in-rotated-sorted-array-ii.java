class Solution {
    public boolean search(int[] nums, int target) {

        int low = 0, high = nums.length-1;
        
        while(low <= high) {
            int mid = low + ((high - low) /2);
            if(nums[mid] == target) {
                return true;
            }
            // this is the special case if the duplicates are found at 
            // low, mid, and high 
            // then shrink the array size ok ✌️
            if(nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low = low + 1;
                high = high - 1;
                continue;
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
        return false;
        
    }
}