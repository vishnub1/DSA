class Solution {
    public boolean isSubsequence(String s, String t) {
        // edge case
        if(s.length() == 0) return true;  // "" string 
        if(s.length() > t.length()) return false;
        

        int i = 0;  // pointing on s
        int j = 0;  // pointing on t

        while(i < s.length() && j < t.length()) {
            if(s.charAt(i) == t.charAt(j)) {
                // ans
                if(i == s.length()-1) {
                    return true;
                }

                i++;
                j++;
            }
            else if(s.charAt(i) != t.charAt(j)) {
                j++;
            }
        }

        return false;
        
    }
}