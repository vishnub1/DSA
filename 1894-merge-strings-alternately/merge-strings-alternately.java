class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder ans = new StringBuilder();

        int i = 0; // word1 pointer
        int j = 0; // word2 pointer

        while(i < word1.length() && j < word2.length()) {
            ans.append(word1.charAt(i));
            ans.append(word2.charAt(j));
            i++;
            j++;
        }

        // when word1 having extra values to contribute
        while(i < word1.length()) {
            ans.append(word1.charAt(i));
            i++;
        }

        // when word2 having extra values to contribute
        while(j < word2.length()) {
            ans.append(word2.charAt(j));
            j++;
        }

        return ans.toString();
    }
}