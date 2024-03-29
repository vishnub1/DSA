class Solution {
    
    public int count1(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    public int[] countBits(int n) {
        int result[] = new int[n+1];

        for(int i = 0; i <= n; i++) {
            int count1 = count1(i);   // count 1 in 'i' in binary representation
            result[i] = count1;
        }

        return result;
    }
}