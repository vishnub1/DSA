class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        // Add all elements to the set
        for (int num : nums) {
            set.add(num);
        }

        int maxLength = 0;

        for (int val : set) {
            // Check if val is the start of a sequence
            if (!set.contains(val - 1)) {
                int currStart = val;
                int currLen = 1;

                // Iterate to find consecutive elements in the sequence
                while (set.contains(currStart + currLen)) {
                    currLen++;
                }

                // Update the maximum length
                maxLength = Math.max(currLen, maxLength);
            }
        }

        return maxLength;
    }
}