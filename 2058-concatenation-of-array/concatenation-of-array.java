class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = 2 * nums.length;

        int arr[] = new int[n];

        int i = 0;
        int j = 0;
        
        while(j < nums.length){
            arr[i] = nums[j];
            i++;
            j++;
        }

        j=0;
        while(j < nums.length){
            arr[i] = nums[j];
            i++;
            j++;
        }   
        return arr;
    }
}