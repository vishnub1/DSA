class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        // Initialize an array to store the indices of the nge for each element
		int nge[] = new int[nums.length];

		Stack<Integer> st = new Stack<>();  // stack to help find NGE

		// calculate NGE for each element in the inout array 
		for(int i = nums.length -1; i >= 0; i--) {
			while(!st.isEmpty() && nums[i] >= nums[st.peek()]) { // st mein index hai 
				st.pop();
			}

			if(st.isEmpty()) {
				nge[i] = nums.length;  // why not -1 think once
			} else {
				nge[i] = st.peek();
			}

			st.push(i);
		}

		
		// Now that we have the NGE information, we can find the 
		// maximum in sliding window
		int[] result = new int[nums.length - k + 1];  
		
		for (int i = 0; i <= nums.length - k; i++) {
			// Initialize j to the current window's starting index.
            int j = i;

			// Find the maximum element within the current window by iterating through NGE indices.
            while (nge[j] < i + k) {  
                j = nge[j];
            }
            result[i] = nums[j];   // assign the max ele found to the result array for the current window 
        }
		
        return result;  // return the ans 
    }
}