class Solution {
    public int minSteps(String s, String t) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            map.put(sChar, map.getOrDefault(sChar, 0) + 1);
            map.put(tChar, map.getOrDefault(tChar, 0) - 1);
        }

        // Absolute Sum
        int sum = 0; 
        for(int i : map.values()) {
            sum += Math.abs(i);
        }

        return sum/2;         
    }
}