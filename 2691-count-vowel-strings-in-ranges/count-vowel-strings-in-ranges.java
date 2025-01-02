class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] isVowelString = new int[n];
        
        // Step 1: Preprocess words to identify which strings start and end with a vowel
        for (int i = 0; i < n; i++) {
            String word = words[i];
            char firstChar = word.charAt(0);
            char lastChar = word.charAt(word.length() - 1);
            if (isVowel(firstChar) && isVowel(lastChar)) {
                isVowelString[i] = 1;
            } else {
                isVowelString[i] = 0;
            }
        }
        
        // Step 2: Compute prefix sum array
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + isVowelString[i - 1];
        }
        
        // Step 3: Process queries
        int m = queries.length;
        int[] result = new int[m];
        for (int i = 0; i < m; i++) {
            int li = queries[i][0];
            int ri = queries[i][1];
            result[i] = prefixSum[ri + 1] - prefixSum[li];
        }
        
        return result;
    }
    // Helper function to check if a character is a vowel
    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}