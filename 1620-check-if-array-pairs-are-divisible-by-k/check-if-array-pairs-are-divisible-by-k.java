class Solution {
    public boolean canArrange(int[] arr, int k) {
        // Array to store remainder counts
        int[] remainderCount = new int[k];

        // Calculate remainder for each element and store the count
        for (int num : arr) {
            int remainder = ((num % k) + k) % k; // Handle negative remainders
            remainderCount[remainder]++;
        }

        // Check pairs for remainder 0 (elements divisible by k)
        if (remainderCount[0] % 2 != 0) {
            return false; // Remainder 0 elements must be even
        }

        // Check for other remainders from 1 to k/2
        for (int i = 1; i <= k / 2; i++) {
            if (remainderCount[i] != remainderCount[k - i]) {
                return false; // The number of elements with remainder i must equal the number with remainder k-i
            }
        }

        return true;
    }
}
