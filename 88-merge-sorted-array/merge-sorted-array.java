class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
       
        int p1 = 0;
        int p2 = 0;
        int i = 0;

        int[] ans = new int[m+n];

        while(p1 < m && p2 < n ) {
            if(nums1[p1] < nums2[p2]) {
                ans[i] = nums1[p1];
                i++;
                p1++;
            } else {
                ans[i] = nums2[p2];
                i++;
                p2++;
            }
        }

        // if any remain
        while(p1 < m) {
            ans[i] = nums1[p1];
            i++;
            p1++;
        }
        while(p2 < n) {
            ans[i] = nums2[p2];
            i++;
            p2++;
        }

        for(int j = 0; j < n + m; j++) {
            nums1[j] = ans[j];
        }

    }
}