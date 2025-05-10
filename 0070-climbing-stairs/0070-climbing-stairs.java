class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = dp[1] = 1;
        climb(n, dp);
        return dp[n];
    }

    public int climb(int n, int[] dp){
        if(n <= 1)return 1;
        if(dp[n] == -1){
            dp[n] = climb(n-1, dp) + climb(n-2, dp);
        }
        return dp[n];
    }
}