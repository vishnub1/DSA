class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n == 0) return 0;

        HashSet<Character> set = new HashSet<>(); 

        int start = 0;
        int end = 0;

        int maxlen = Integer.MIN_VALUE;
        int currlen = 0;

        while(end < n) {
            
            if(!set.contains(s.charAt(end))) {
                currlen += 1;
                maxlen = Math.max(maxlen, currlen);
                set.add(s.charAt(end));
                end++;
            } else {  
                currlen = currlen - 1;  // minus first element 
                set.remove(s.charAt(start));  // remove from start pointer
                start++;
            }
        }
        
        return maxlen;
    }
}