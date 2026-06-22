class Solution {
   
        

    int[][] dp;

    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public int longestIncreasingPath(int[][] matrix) {

        int m = matrix.length;

        int n = matrix[0].length;

        dp = new int[m][n];

        int ans = 0;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                ans = Math.max(ans, dfs(i, j, matrix));
            }
        }

        return ans;
    }

    int dfs(int i, int j, int[][] matrix) {

        // Already computed
        if (dp[i][j] != 0) {

            return dp[i][j];
        }

        int m = matrix.length;

        int n = matrix[0].length;

        int maxLen = 1; // At least the current cell

        for (int[] d : dir) {

            int ni = i + d[0];

            int nj = j + d[1];

            if (ni >= 0 && ni < m &&
                nj >= 0 && nj < n &&
                matrix[ni][nj] > matrix[i][j]) {

                maxLen = Math.max(maxLen,
                          1 + dfs(ni, nj, matrix));
            }
        }

        dp[i][j] = maxLen;

        return maxLen;
    }
}
