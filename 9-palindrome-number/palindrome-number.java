class Solution {
    public boolean isPalindrome(int x) {
        
        if(x < 0) { // for negative 
            return false;
        }

        String num = Integer.toString(x);
        int n = num.length();
        
        int start = 0; 
        int end = n-1;

        while(start <= end) {
            if(num.charAt(start) != num.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        
        return true;
    }
}