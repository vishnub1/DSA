class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;
        int stations[] = new int[1001];

        for(int trip[] : trips) {
            int numPassenger = trip[0];
            int from = trip[1];
            int to = trip[2];   // extracting val from 2d array 

            stations[from] += numPassenger;
            stations[to] -= numPassenger;
        }

        // fill the stations array with prefix sum 
        for(int i = 1; i < 1001; i++) {
            stations[i] += stations[i - 1];
        }

        // Now checking possible or not
        for(int i = 0; i < 1001; i++) {
            if(stations[i] > capacity) {
                return false;
            }
        }
        return true;
    }
}