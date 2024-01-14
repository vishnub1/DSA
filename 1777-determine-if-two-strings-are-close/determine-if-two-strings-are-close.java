class Solution {
    public boolean closeStrings(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if(n != m) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        boolean[] present1 = new boolean[26];
        boolean[] present2 = new boolean[26];

        for (int i = 0; i < n; i++) {
            char ch1 = word1.charAt(i);
            char ch2 = word2.charAt(i);

            freq1[ch1 - 'a']++;
            present1[ch1 - 'a'] = true;

            freq2[ch2 - 'a']++;
            present2[ch2 - 'a'] = true;
        }


        Arrays.sort(freq1);
        Arrays.sort(freq2);

        return Arrays.equals(freq1, freq2) && Arrays.equals(present1, present2);
    }
}