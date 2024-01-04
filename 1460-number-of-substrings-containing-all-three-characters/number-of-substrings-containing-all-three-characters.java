class Solution {
    public int numberOfSubstrings(String s) {
        Map<Character, Integer> charFreqMap = new HashMap<>();
        int numSubString = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            charFreqMap.put(rightChar, charFreqMap.getOrDefault(rightChar, 0) + 1);

            // shrinking window left++
            while (charFreqMap.size() >= 3) {
                char leftChar = s.charAt(left);
                charFreqMap.put(leftChar, charFreqMap.get(leftChar) - 1);

                if (charFreqMap.get(leftChar) == 0) {
                    charFreqMap.remove(leftChar);
                }
                left++;
            }

            numSubString += left;
        }

        return numSubString;
    }
}