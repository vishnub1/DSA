class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int result[] = new int[n-k+1];
        int st = 0;

        Deque<Integer> dq = new ArrayDeque<>();  // storing index
        for(int i = 0; i < n; i++) {
            // removing index from front which is not in range of k 
            while(!dq.isEmpty() && dq.peek() < i-k+1) {
                dq.poll();
            }

            // removing index from last which has smaller value than curr element 
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            
            dq.offer(i);
            if(i >= k -1) {
                result[st++] = nums[dq.peek()];
            }
        }

        return result;
    }
}