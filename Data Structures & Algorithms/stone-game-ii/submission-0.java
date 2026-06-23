class Solution {
   
    int[][] dp;
    int[] suffix;
    int n;

    public int stoneGameII(int[] piles) {

        n = piles.length;

        dp = new int[n][2 * n + 1];

        // suffix[i] = sum of piles from i to n-1
        suffix = new int[n + 1];

        for(int i = n - 1; i >= 0; i--) {

            suffix[i] = suffix[i + 1] + piles[i];
        }

        return solve(0, 1, piles);
    }

    int solve(int i, int M, int[] piles) {

        // No piles left
        if(i >= n)
            return 0;

        // Can take all remaining piles
        if(i + 2 * M >= n)
            return suffix[i];

        if(dp[i][M] != 0)
            return dp[i][M];

        int ans = 0;

        // Try taking X piles
        for(int X = 1; X <= 2 * M; X++) {

            ans = Math.max(
                    ans,

                    suffix[i]
                    - solve(i + X,
                            Math.max(M, X),
                            piles)
                  );
        }

        return dp[i][M] = ans;
        
    }
}