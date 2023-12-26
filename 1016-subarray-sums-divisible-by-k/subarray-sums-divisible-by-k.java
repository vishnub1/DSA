class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefSum = 0;
        int count = 0;  // how many subarray which is divisible by k

        for(int i = 0; i < nums.length; i++) {
            prefSum += nums[i];
            int remainder = prefSum % k;
            if(remainder < 0) remainder = remainder + k;  // when rem becomes -ne make them +ve 

            if(map.containsKey(remainder)) {
                count += map.get(remainder);
            }
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }
}