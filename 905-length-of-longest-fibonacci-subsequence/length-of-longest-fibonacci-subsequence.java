import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(arr[i], i);
        }

        Map<String, Integer> dp = new HashMap<>();
        int maxLen = 0;

        for (int k = 0; k < n; k++) {
            for (int j = 0; j < k; j++) {
                int iVal = arr[k] - arr[j]; // Calculate the potential previous value
                if (iVal < arr[j] && indexMap.containsKey(iVal)) {
                    int i = indexMap.get(iVal);
                    String key = i + "," + j;
                    int len = dp.getOrDefault(key, 2) + 1; // Default length is 2
                    dp.put(j + "," + k, len);
                    maxLen = Math.max(maxLen, len);
                }
            }
        }

        return maxLen > 2 ? maxLen : 0; // Return 0 if no Fibonacci-like subsequence exists
    }
}
