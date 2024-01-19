class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];

        // Check if the starting pixel color is different from the new color
        if (originalColor != color) {
            bfs(image, sr, sc, originalColor, color);
        }

        return image;
    }

    private void bfs(int[][] image, int sr, int sc, int originalColor, int newColor) {
        int rows = image.length;
        int cols = image[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // 4-directions: right, left, down, up

        while (!queue.isEmpty()) {
            int[] currentPixel = queue.poll();
            int row = currentPixel[0];
            int col = currentPixel[1];

            // Check if the current pixel has the same color as the starting pixel
            if (image[row][col] == originalColor) {
                // Update the color of the current pixel
                image[row][col] = newColor;

                // Explore the 4-directionally connected pixels
                for (int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    // Check if the new position is within the image boundaries
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                        // Add the 4-directionally connected pixels to the queue
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }
    }
}