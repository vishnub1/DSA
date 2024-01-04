class Solution {
    
    public boolean isValid(HashMap<Character, Integer> ideal, HashMap<Character, Integer> curr) {
        if (ideal.size() > curr.size())
            return false; // directly

        for (char key : ideal.keySet()) {
            if (!curr.containsKey(key)) {
                return false;
            } else if (curr.get(key) < ideal.get(key)) {
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {
        int ansLen = Integer.MAX_VALUE;
        String ans = "";
        HashMap<Character, Integer> ideal = new HashMap<>(); // val's of t
        HashMap<Character, Integer> curr = new HashMap<>();

        // filling ideal map
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            ideal.put(ch, ideal.getOrDefault(ch, 0) + 1);
        }

        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            // introduce
            char currChar = s.charAt(end);
            curr.put(currChar, curr.getOrDefault(currChar, 0) + 1);

            while (isValid(ideal, curr)) {
                // Update answer
                if (ansLen > (end - start + 1)) {
                    ansLen = end - start + 1;
                    ans = s.substring(start, end + 1); // ans
                }
                // Shrink
                curr.put(s.charAt(start), curr.get(s.charAt(start)) - 1);
                start++;
            }
        }

        return ans;
    }
}