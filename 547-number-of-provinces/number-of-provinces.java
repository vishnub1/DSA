class Solution {

    public void bfs(int[][] M, boolean visited[], int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);  // add
        visited[node] = true;

        while(!q.isEmpty()) {
            int curr = q.poll(); // remove 

            for(int i = 0; i < M.length; i++) {
                if(M[curr][i] == 1 && !visited[i]) {
                    q.add(i); // traverse the first friends (BFS) 
                    visited[i] = true;  
                }
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
                bfs(M, visited, i);
            }
        }

        return count;
    }
}