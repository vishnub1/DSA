class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        // Initialize variables for result, needed remainder, and current remainder
        int res = n, need = 0, curr = 0;

        // calculate the total remainder needed for the array
        for (int a : nums) {
            need = (need + a) % p;
        }

        // Create a map to store the last index for each remainder value
        Map<Integer, Integer> last = new HashMap<>();
        last.put(0, -1);

        // Traverse the array to find the minimum subarrray length
        for (int i = 0; i < n; i++) {
            // Update the current remainder
            curr = (curr + nums[i]) % p;

            // store the current index for the current remainder in the map
            last.put(curr, i);

            // calculate the remainder we want to achieve
            int want = (curr - need + p) % p;

            // update the result with the minimum subarray length
            res = Math.min(res, i - last.getOrDefault(want, -n));
        }

        // If a valid subarray is found, return its length, else return -1;
        return res < n ? res : -1;
    }
}