class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();

        // Count the frequency of each character in string 's'
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Reduce the freq of each character found in string 't'
        for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if(map.containsKey(ch) == false) {
                return false;
            } 
            map.put(ch, map.get(ch) -1);
            if(map.get(ch) == 0) {
                map.remove(ch); // Remove character form the map
            }
        }

        // If the map is empty, 's' and 't' are anagrams
        return map.isEmpty();
        
    }
}