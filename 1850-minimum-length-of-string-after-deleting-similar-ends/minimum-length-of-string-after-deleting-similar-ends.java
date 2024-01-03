class Solution {
    public int minimumLength(String s) {
        int n = s.length();

        int left = 0;
        int right = n-1;

        char arr[] = s.toCharArray();

        while(left < right) {
            if(arr[left] == arr[right]) {
                left++;
                right--;
                
                while(left < right && arr[left] == arr[left-1]) left++;
                while(left <= right && arr[right] == arr[right+1]) right--;
            }
            else {
                break;
            }
        }

        return right - left + 1; 
    }
}