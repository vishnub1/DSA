class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        int result = Integer.MAX_VALUE;
        int left = 0;
        int right = n-1;

        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                break;
            }
            
            char c = s.charAt(left);
                
            while(left <= right && c == s.charAt(left)) left++;

            // left can reach right, so need to check for equality also
            while(left <= right && c == s.charAt(right)) right--;

        }

        return right - left + 1;
    }
}