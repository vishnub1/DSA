class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        String str = "";
        
        for(int i = 0; i < s.length(); i++) {
            str = "";
            for(int j = i; j < s.length(); j++) {
                char curr = s.charAt(j);
                str += curr;
                if(isPalindrome(str)) {
                    count++;
                }
            }
        }

        return count;
    }

    public boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length()-1;

        while(start < end) {
            if(str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}