class Solution {
    public int hammingDistance(int a, int b) {
        int xor = a ^ b;  // after doing this will having the different
        // position denoting with 1  so count them
        
        int distance = 0;
        while(xor > 0) {
            if((xor & 1) == 1) {
                distance++;
            }
            xor = xor >> 1;
        }

        return distance;
    }
}