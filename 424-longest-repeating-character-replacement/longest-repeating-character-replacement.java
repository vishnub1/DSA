class Solution {
    public int characterReplacement(String s, int k) {
        int[] charCount = new int[26]; // to store the count of characters in the current window
        int maxCount = 0; // to keep track of the maximum repeating character count in the current window
        int maxLength = 0; // to store the length of the longest substring containing the same letter

        int start = 0; // start of the window

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);
            charCount[currentChar - 'A']++; // increment count of the current character in the window
            maxCount = Math.max(maxCount, charCount[currentChar - 'A']); // update maxCount

            // If the size of the window (end - start + 1) minus maxCount is greater than k,
            // shrink the window from the left side
            if (end - start + 1 - maxCount > k) {
                charCount[s.charAt(start) - 'A']--; // decrement count of the character going out of the window
                start++; // move the window to the right
            }

            // Update maxLength with the current window size
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}
