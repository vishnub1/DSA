class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        // Create a HashMap to store the anagrams. 
        // The key is the sorted version of the word, and the value is a list of anagrams.
        Map<String, List<String>> map = new HashMap<>();
        
        // Iterate through each word in the input array
        for(String word : strs) {
            char[] chars = word.toCharArray();
            
            Arrays.sort(chars);
            
            // Convert the sorted character array back into a string (the sorted version of the word)
            String sortedWord = new String(chars);
            
            // If the sortedWord is not already in the map, add it with an empty list
            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }
            
            // Add the original word to the list corresponding to its sorted version
            map.get(sortedWord).add(word);
        }

        // Return a new ArrayList containing all the grouped anagrams (the values of the map)
        return new ArrayList<>(map.values());
    }
}
