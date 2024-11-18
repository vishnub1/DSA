class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int ans[] = new int[n];

        if (k == 0) { 
            Arrays.fill(ans, 0); // Fill with zeros if k == 0
            return ans;
        } else if (k > 0) { 
            return nextSum(code, k); // Sum of the next k numbers
        } else { 
            return previousSum(code, -k); // Sum of the previous k numbers (convert k to positive)
        }
    }

    public static int[] nextSum(int[] code, int k) {
        int n = code.length;
        int ans[] = new int[n];

        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = 1; j <= k; j++) {
                sum += code[(i+j)%n]; // wrap aound using modulo
            }
            ans[i] = sum;
        }
        return ans;
    }

    public static int[] previousSum(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 1; j <= k; j++) {
                sum += code[(i - j + n) % n]; // Wrap around using modulo
            }
            ans[i] = sum;
        }
        return ans;
    }

}