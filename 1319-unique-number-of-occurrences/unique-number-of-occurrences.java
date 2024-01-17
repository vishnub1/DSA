class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        // number with freq
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        // checking 
        Set<Integer> set = new HashSet<>();
        for (int x : map.values()) {
            set.add(x);
        }

        return map.size() == set.size();
    }
}