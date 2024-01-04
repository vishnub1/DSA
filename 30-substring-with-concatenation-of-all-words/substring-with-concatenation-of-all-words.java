class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int wordCount = words.length;
        HashMap<String, Integer> wordFreqMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        // Populate word frequency map
        for (int i = 0; i < wordCount; i++) {
            wordFreqMap.put(words[i], wordFreqMap.getOrDefault(words[i], 0) + 1);
        }

        int totalLength = words[0].length() * wordCount;  // total length of word array with strings 
        int wordLength = words[0].length();  // perticular word length 
        int startIndex = 0;
        int endIndex = 0;

        while (endIndex < s.length()) {
            // Check if the current substring is of the required length
            if (endIndex - startIndex + 1 == totalLength) {
                String currSubString = s.substring(startIndex, endIndex + 1);
                HashMap<String, Integer> currSubStringMap = new HashMap<>();

                // Populate map fro the current substring
                int pointer = 0;
                while (pointer < currSubString.length()) {
                    String currWord = currSubString.substring(pointer, pointer + wordLength);
                    currSubStringMap.put(currWord, currSubStringMap.getOrDefault(currWord, 0) + 1);
                    pointer += wordLength;
                }

                // Compare the maps to check if they are equal
                if (wordFreqMap.equals(currSubStringMap)) {
                    result.add(startIndex);
                }

                startIndex++;
            }

            endIndex++;
        }

        return result;
    }
}
