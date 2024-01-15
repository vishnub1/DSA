class Solution {
    
   public static boolean dfs(List<List<Integer>> graph, boolean vis[], boolean path[], int curr) {
        // mark
        path[curr] = true;
        vis[curr] = true;

        // Work - nothing

        // Try to visit unvisited nbrs
        for (int nbrs : graph.get(curr)) {
            if (path[nbrs]) return true;  // cycle found
            else if (!vis[nbrs]) {  // visit unvisited nbrs
                boolean isCyclic = dfs(graph, vis, path, nbrs);
                if (isCyclic) return true;
            }
        }
        // Unmark the path array
        path[curr] = false;  // backtracking
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // Pushing the graph value to adj list
        for (int[] prereq : prerequisites) {
            graph.get(prereq[1]).add(prereq[0]);
        }

        boolean vis[] = new boolean[numCourses];
        boolean path[] = new boolean[numCourses];

        // Applying dfs
        for (int src = 0; src < numCourses; src++) {
            if (!vis[src]) {
                // Try to find a cycle in the component where src is treated as the src
                if (dfs(graph, vis, path, src)) return false;
            }
        }
        return true; // no cycle found
    }

}