class Solution {
    public int findMin(int[] nums) {
        
        int low = 0, high = nums.length-1;
        int ans = Integer.MAX_VALUE;

        while(low <= high) {
            int mid = (low + high) / 2;

            // here also special case applied
            // wehere left and right part are sorted
            // if(nums[low] <= nums[mid] && nums[mid] <= nums[high]) {
            //     ans = Math.min(ans, nums[low]);
            //     low = low+1;
            //     high = high-1;
            //     continue;
            // } 
            
            if (nums[low] <= nums[mid]) {  //left part is sorted 
                    ans = Math.min(ans, nums[low]); 
                    low = mid + 1;
                } else {
                    high = mid - 1;
                    ans = Math.min(ans, nums[mid]);
                }
            }

        return ans;
    }
}