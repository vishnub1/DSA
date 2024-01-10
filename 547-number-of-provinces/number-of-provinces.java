class Solution {

    public static void dfs(int[][] M, boolean visited[], int node) {
        visited[node] = true;

        for(int i = 0; i < M.length; i++) {
            if(M[node][i] == 1 && !visited[i]) {
                dfs(M, visited, i); // traverse for nbrs
            }
        }
    }

    public int findCircleNum(int[][] M) {
        int n = M.length;
        int count = 0;
        boolean visited[] = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                count++;
                dfs(M, visited, i);
            }
        }

        return count;
    }
}