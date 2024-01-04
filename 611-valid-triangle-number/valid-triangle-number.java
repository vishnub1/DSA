class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);

        int count = 0;

        for(int end = nums.length-1; end >= 0; end--) {
            int middle = end - 1;
            int start = 0;

            while(start < middle) {
                // in an sorted array if start and middle element sum is greater than the last idx ele
                // then from start to middle all element sum is always greater than last idx value
                if(nums[start] + nums[middle] > nums[end]) {   
                    count += middle - start;  // meditate why this taken it's imp 
                    middle--;
                } else {
                    start++;
                }
            }
        }

        return count;
    }
}