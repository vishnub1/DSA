class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int nsr[] = new int[n]; // // next smaller right (right boundary)
        int nsl[] = new int[n]; // next smaller left (left boundary)

        // next smaller right (right boundary)
        Stack < Integer > st = new Stack < > ();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                st.pop();
            }

            if (st.isEmpty()) {
                nsr[i] = n; // heights.length  // idx storing / size storing
            } else {
                nsr[i] = st.peek(); // set the next i as peek
            }
            st.push(i); // pushing the idx value not idx elements
        }

        // next smaller left
        st = new Stack < > ();

        for (int i = 0; i < heights.length; i++) {
            while (!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                st.pop();
            }

            if (st.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = st.peek();
            }

            st.push(i);
        }

        int maxArea = 0;
        // current area = height  *   width 
        //                heights[i] * (nsr[i] - nsl[i] - 1)
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = height * width;
            maxArea = Math.max(currArea, maxArea);
        }

        return maxArea;
    }
}