class Solution {
    public int sumSubarrayMins(int[] arr) {
        int nextSm[] = nextSmaller(arr);
        int prevSm[] = prevSmaller(arr);

        long ans = 0;
        int mod = 1000000007;

        for (int i = 0; i < arr.length; i++) {
            // Number of subarrays where arr[i] is the minimum
            long first = nextSm[i] - i;
            long second = i - prevSm[i];

            // Calculate the contribution of arr[i] as the minimum in the subarrays
            long product = (first * second) % mod;
            product = (product * arr[i]) % mod;

            // Add to the final answer
            ans = (ans + product) % mod;

        }

        return (int) ans;
    }

    // Next Smaller
    private int[] nextSmaller(int arr[]) {
        Stack < Integer > st = new Stack < > ();
        int nse[] = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                nse[i] = arr.length;
            } else {
                nse[i] = st.peek();
            }
            st.push(i);
        }
        return nse;
    }

    // Previous Smaller
    private int[] prevSmaller(int arr[]) {
        Stack < Integer > st = new Stack < > ();
        int pse[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                pse[i] = -1;
            } else {
                pse[i] = st.peek();
            }
            st.push(i);
        }
        return pse;
    }

}