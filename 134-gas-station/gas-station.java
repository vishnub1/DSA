class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int n = gas.length;
        int totalDiff = 0, fule = 0;
        int index = 0;

        for(int i = 0; i < n; i++) {
            int diff = gas[i] - cost[i];
            totalDiff += diff;
            fule += diff;

            if(fule < 0) {
                index = i + 1;
                fule = 0;
            }
        }

        return (totalDiff < 0) ? -1 : index;  
    }
}