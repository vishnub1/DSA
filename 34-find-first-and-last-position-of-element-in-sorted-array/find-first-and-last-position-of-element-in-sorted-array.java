class Solution {

    public static int indexOfFirstOccu(int a[], int k) {
        int n = a.length;
        int start = 0, end = n - 1;
        int ans = n; // we can assign max index because we have to cal first occu

        while (start <= end) {
            int mid = (start + end) / 2;
            if (a[mid] == k) {
                ans = mid;     // may be ans
                end = mid - 1; // we need minimum index of k that is why we go left
            } else if (k < a[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (ans == n) { // element not found
            ans = -1;
        }

        return ans;
    }

    public static int indexOfLastOccu(int a[], int k) {
        int n = a.length;
        int start = 0,  end = n - 1;
        int ans = -1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (a[mid] == k) {
                ans = mid;
                start = mid + 1;
            } else if (k < a[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        int firstIdx = indexOfFirstOccu(nums, target);
        int lastIdx = indexOfLastOccu(nums, target);
        int ans[] = { firstIdx, lastIdx };
        return ans;

    }
}