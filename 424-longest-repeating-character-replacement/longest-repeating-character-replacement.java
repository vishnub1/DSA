class Solution {
    public int characterReplacement(String s, int k) {
        // Make an array of size 26
        int arr[] = new int[26];

        // intitialize largestCount, maxlen, & beg pointer
        int largestCount = 0;
        int start = 0;
        int maxLen = 0;

        // Traverse all character through the loop
        for(int end = 0; end < s.length(); end++) {
            arr[s.charAt(end) - 'A']++;  // freq array

            // Get the largest count of a single, unique character int the current window
            largestCount = Math.max(largestCount, arr[s.charAt(end) - 'A']);

            // we are allowed to have at most k replacements in the window 
            // so, if max character frequency + distance between start and end is greater than k
            // this means we have considered changing more than k characters, so time to shrink the window
            // Then there are more characters in the window than we can relpace and we need to shrinkthe window
            // ( window length - largestCount  > k )
            if(end-start+1 - largestCount > k) {
                arr[s.charAt(start) - 'A']--;
                start++;
            }

            // get the maximum length of repeating character 
            maxLen = Math.max(maxLen, end-start+1);
        }

        return maxLen;
    }
}