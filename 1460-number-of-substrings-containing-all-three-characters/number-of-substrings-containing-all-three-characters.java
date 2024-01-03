class Solution {
    public int numberOfSubstrings(String s) {
        int aCount = 0;
        int bCount = 0;
        int cCount = 0;

        // using sliding window
        int left = 0;
        int right = 0;
        int result = 0;

        while (right < s.length()) {
            if (s.charAt(right) == 'a') {
                aCount++;
            } else if (s.charAt(right) == 'b') {
                bCount++;
            } else if (s.charAt(right) == 'c') {
                cCount++;
            }

            // Contract the window
            while (aCount > 0 && bCount > 0 && cCount > 0) {
                // If all characters are present, update result
                result += s.length() - right;

                // Move the left pointer to contract the window
                if (s.charAt(left) == 'a') {
                    aCount--;
                } else if (s.charAt(left) == 'b') {
                    bCount--;
                } else if (s.charAt(left) == 'c') {
                    cCount--;
                }
                left++;
            }

            // Move the right pointer to expand the window
            right++;
        }

        return result;
    }
}