class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        // 2 Pointer Approach 
        // Sort the array 
        Arrays.sort(nums);   

        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int j = i + 1;
            int k = n - 1;

            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if(sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else { // sum == 0
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    
                    result.add(list);
                    
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j-1]) j++; // skip duplicate 
                    while(j < k && nums[k] == nums[k+1]) k--; // skip duplicate 
                }
            }
        }

        return result;
    }
}
