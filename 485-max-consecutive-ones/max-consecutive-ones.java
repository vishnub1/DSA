class Solution {
    public int findMaxConsecutiveOnes(int[] arr) {
        int n = arr.length;
        int count = 0;
        int maxCount = 0;
        int start = 0;
        int end = 0;

        while (end < n) {
            if (arr[start] == 1 && arr[end] == 1) {
                count++;
                maxCount = Math.max(maxCount, count);
                end++;
            } else if (arr[end] == 0) {
                start++;
                end++;
                count = 0;
            } else if (arr[start] == 0) {
                start++;
                count = 0;
            }
        }

        return maxCount;
    }
}