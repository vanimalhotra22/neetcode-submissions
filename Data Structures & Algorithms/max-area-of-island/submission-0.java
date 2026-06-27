class Solution {
    public int maxAreaOfIsland(int[][] grid) {
         int max = 0;

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1) {

                    int area = dfs(grid, i, j);

                    max = Math.max(max, area);
                }
            }
        }

        return max;
    }

    int dfs(int[][] grid, int row, int col) {

        // Base Case
        if (row < 0 || col < 0 ||
            row >= grid.length ||
            col >= grid[0].length ||
            grid[row][col] == 0) {

            return 0;
        }

        // Mark visited
        grid[row][col] = 0;

        int up = dfs(grid, row - 1, col);
        int down = dfs(grid, row + 1, col);
        int left = dfs(grid, row, col - 1);
        int right = dfs(grid, row, col + 1);

        return 1 + up + down + left + right;
    }
}
