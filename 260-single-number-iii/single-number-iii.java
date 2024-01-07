class Solution {

    public int findSetBit(int n) {
        int k = 0;
        while ((n & 1) != 1) {
            n >>= 1;
            k++;
        }
        return k;
    }

    public boolean checkBit(int num, int k) {
        // return ((num >> k) & 1) == 1;

        if (((num >> k) & 1) != 0) {
            return true;
        } else {
            return false;
        }
    }

    public int[] singleNumber(int[] nums) {
        int n = nums.length;
        // taking all XOR
        int xorAll = 0;
        for (int i = 0; i < n; i++) {
            xorAll ^= nums[i];
        }

        // now find the kth set bit from left
        int k = findSetBit(xorAll);

        // now make the two groups
        // 1's with kth position 0
        // 2nd with kth position 1

        int kthOne = 0;
        int kthZero = 0;

        for (int i = 0; i < n; i++) {
            if (checkBit(nums[i], k)) { // 1
                kthOne ^= nums[i];
            } else {
                kthZero ^= nums[i];
            }
        }

        int ans[] = new int[2];
        ans[0] = kthOne;
        ans[1] = kthZero;

        Arrays.sort(ans);
        return ans;
    }
}
