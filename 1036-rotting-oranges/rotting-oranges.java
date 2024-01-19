class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int count_fresh = 0;

        // Put the position of all rotten oranges in queue
        // count the number of fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j }); // {row, col}
                }
                if (grid[i][j] == 1) { // count fresh orange
                    count_fresh++;
                }
            }
        }

        if (count_fresh == 0)
            return 0;

        int countTime = 0, cnt = 0;
        // - For Movement (L,R,D,U)
        int dx[] = { 0, 0, 1, -1 };
        int dy[] = { -1, 1, 0, 0 };

        // BFS starting from initially rotten oranges
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] point = q.poll(); // {row, col}

                for (int j = 0; j < 4; j++) {
                    int x = point[0] + dx[j];
                    int y = point[1] + dy[j];

                    if (x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || grid[x][y] == 2) {
                        continue;
                    }

                    grid[x][y] = 2;
                    q.add(new int[] { x, y });
                    count_fresh--;
                }
            }

            if (q.size() != 0) {
                countTime++;
            }
        }

        return count_fresh == 0 ? countTime : -1;
    }
}