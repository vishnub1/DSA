class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        int maxVal = Integer.MIN_VALUE;
        
        // int res[] = {Integer.MIN_VALUE, Integer.MAX_VALUE};    this will gives error because of overfolw
        int res[] = {-100000, 100000}; // Correct initialization

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0] - b[0]));
        //0th -> val, 1st -> index, 2nd -> listNo

        // Adding first elements from every list
        for(int i = 0; i < k; i++) {
            pq.add(new int[] {nums.get(i).get(0), 0, i}); //{val,idx,listNo}
            maxVal = Math.max(maxVal, nums.get(i).get(0)); // every list first element
        }

        while(pq.size() == k) {
            int[] arr = pq.poll();

            int minVal = arr[0];
            int currRange =  maxVal - minVal; // maxVal - min + 1 from curr arr
            int resRange = res[1] - res[0];  // maxVal - min + 1 from result

            // Updating ans array if it's valid
            if(currRange < resRange) {
                res[0] = minVal;
                res[1] = maxVal;
            }

            int idx = arr[1];
            int list = arr[2];

            // adding list to pq 
            if(idx + 1 < nums.get(list).size()) {
                pq.add(new int[] {nums.get(list).get(idx+1), idx+1, list});
                maxVal = Math.max(maxVal, nums.get(list).get(idx + 1));
            }
        }

        return res;
    }
}
