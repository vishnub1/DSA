class Solution {
    public int sumSubarrayMins(int[] a) {
        int n = a.length;
        Stack<Integer> st = new Stack<>();
		
        // nsl - left Boundary 
        int nsl[] = new int[n];
        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && a[i] < a[st.peek()]) {
                st.pop();
            }
            if(st.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = st.peek();
            }
            st.push(i);
        }

        st = new Stack<>();
        // nsr - Right Boundary 
        int nsr[] = new int[n];
        for(int i = n-1; i >= 0; i--) {
            while(!st.isEmpty() && a[i] <= a[st.peek()]) {
                st.pop();
            }
            if(st.isEmpty()) {
                nsr[i] = n;
            } else {
                nsr[i] = st.peek();
            }
            st.push(i);
        }

        long mod = 1000000007;
        long totalSum = 0;
        for(int i = 0; i < n; i++) {
            long left = i - nsl[i];
            long right = nsr[i] - i;

            // (a*b)%m = (a%m * b%m)%m (Modulus Property)
            long numberOfSubarray = (left % mod * right % mod) % mod;
            long sum = (a[i] % mod * numberOfSubarray % mod) % mod;

            // (a+b)%m = (a%m + b%m)%m (Modulus Property)
            totalSum = (totalSum % mod + sum % mod) % mod;
        }

        return (int)totalSum;
    }
}