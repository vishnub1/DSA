class Solution {
    public int maxScore(String s) {
        int totalOnes = 0;
        int zeroCount = 0;
        int onesCount = 0;
        int maxScore = Integer.MIN_VALUE;

        // count total ones in the string 
        for(char ch : s.toCharArray()) {
            if(ch == '1') {
                totalOnes++;
            }
        }

        // Traverse the string and calculate score
        for(int i = 0; i < s.length()-1; i++) {
            if(s.charAt(i) == '0'){
                zeroCount++;  // pivot point 
            } else {
                onesCount++;
            }

            maxScore = Math.max(zeroCount +(totalOnes - onesCount), maxScore);
        }

        return maxScore;
    }
}