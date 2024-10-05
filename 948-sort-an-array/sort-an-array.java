class Solution {
    public int[] sortArray(int[] nums) {
        // Call the mergeSort function
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
    
    // Merge Sort helper function
    private void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return; // If there's only one element or the subarray is empty
        }
        
        // Calculate the mid-point
        int mid = left + (right - left) / 2;
        
        // Recursively sort the two halves
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        
        // Merge the two sorted halves
        merge(arr, left, mid, right);
    }
    
    // Merge two sorted halves
    private void merge(int[] arr, int left, int mid, int right) {
        // Temporary array to store the merged result
        int[] merged = new int[right - left + 1];
        int idx1 = left;    // Starting index of left half
        int idx2 = mid + 1; // Starting index of right half
        int idx = 0;        // Index for merged array
        
        // Merge both halves into the temporary array
        while (idx1 <= mid && idx2 <= right) {
            if (arr[idx1] <= arr[idx2]) {
                merged[idx++] = arr[idx1++];
            } else {
                merged[idx++] = arr[idx2++];
            }
        }
        
        // Copy any remaining elements from the left half
        while (idx1 <= mid) {
            merged[idx++] = arr[idx1++];
        }
        
        // Copy any remaining elements from the right half
        while (idx2 <= right) {
            merged[idx++] = arr[idx2++];
        }
        
        // Copy the merged array back to the original array
        for (int i = 0, j = left; i < merged.length; i++, j++) {
            arr[j] = merged[i];
        }
    }
}
