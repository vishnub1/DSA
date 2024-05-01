class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1;
        int p2 = n-1;
        int idx = m+n-1;

        while(p1 >= 0 && p2 >= 0) {
            if(nums1[p1] > nums2[p2]) {
                nums1[idx] = nums1[p1];
                p1--;
            } else {
                nums1[idx] = nums2[p2];
                p2--;
            }
            idx--;
        }

        //if there are remaining ele,emt in nums2, add then to nums1
        while(p2 >= 0) {
            nums1[idx] = nums2[idx];
            p2--;
            idx--;
        }
    }
}