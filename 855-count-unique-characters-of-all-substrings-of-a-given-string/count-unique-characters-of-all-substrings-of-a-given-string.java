// import java.util.*;

class Solution {
    private static final int MOD = 1000000007;

    public int uniqueLetterString(String s) {
        int n = s.length();
        List<List<Integer>> hashmap = new ArrayList<>(26);

        // Initialize the hashmap for each character with a list containing -1
        for (int i = 0; i < 26; i++) {
            hashmap.add(new ArrayList<>());
            hashmap.get(i).add(-1);  // Push -1 for all keys in value list
        }

        // Store all indices of each character in the hashmap
        for (int i = 0; i < n; i++) {
            hashmap.get(s.charAt(i) - 'A').add(i);
        }

        // Push length of the string for all keys at the end of each value list
        for (int i = 0; i < 26; i++) {
            hashmap.get(i).add(n);  // Push string length at the end of each list
        }

        long count = 0;
        
        // Calculate the unique letter contribution for each character
        for (int i = 0; i < 26; i++) {
            List<Integer> indices = hashmap.get(i);
            for (int j = 1; j < indices.size() - 1; j++) {
                count += (long)(indices.get(j) - indices.get(j - 1)) * (indices.get(j + 1) - indices.get(j));
                count %= MOD;  // Ensure count doesn't exceed the MOD
            }
        }

        return (int) count;  // Return the count mod 1000000007
    }
}
