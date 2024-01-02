class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>(); // ele, index 

        int len = 0;
        int start = 0;
        int end = 0;

        while(end < s.length()) {
            if(map.containsKey(s.charAt(end))) {  // Dublicate ele found, update start pointer
                start = Math.max(map.get(s.charAt(end)) + 1, start);
            }

            map.put(s.charAt(end), end);
            len = Math.max(len, end - start + 1);

            end++;
        }
        return len;
    }
}