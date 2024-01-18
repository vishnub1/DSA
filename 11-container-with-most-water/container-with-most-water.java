class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;  

        int li = 0;
        int ri = height.length - 1;

        while(li < ri)  {
            int left = height[li];  // for height min candidate 
            int right = height[ri];

            // area = height * width
            int area = Math.min(left, right) * (ri - li);
            maxArea = Math.max(maxArea, area);

            if(left < right) {
                li++;
            } else {
                ri--;
            }
        }

        return maxArea;
    }
}