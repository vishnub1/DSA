class Solution {
    public int findKthLargest(int[] nums, int k) {
         // Using a min-heap to keep track of the k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the smallest element
            }
        }

        // The root of the min-heap is the k-th largest element
        return minHeap.peek();
    }
}