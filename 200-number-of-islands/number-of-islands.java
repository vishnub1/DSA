import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int first;
    int second;
    
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    // BFS 
    public void bfs(int ro, int co, int vis[][], char grid[][], int n, int m) {
        int[] dr = {-1, 0, 1, 0}; // direction arrays to move in 4 directions
        int[] dc = {0, 1, 0, -1};

        vis[ro][co] = 1;
        Queue<Pair> q = new LinkedList<>();  
        q.add(new Pair(ro, co));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int row = curr.first;
            int col = curr.second;

            // Traverse in all 4 directions
            for (int i = 0; i < 4; i++) {
                int nrow = row + dr[i];
                int ncol = col + dc[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m 
                    && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0) {
                    vis[nrow][ncol] = 1; // mark visited 
                    q.add(new Pair(nrow, ncol));
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];

        int count = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (vis[row][col] == 0 && grid[row][col] == '1') {
                    count++;
                    bfs(row, col, vis, grid, n, m);
                }
            }
        }

        return count;
    }
}
