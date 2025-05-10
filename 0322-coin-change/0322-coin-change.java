class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -2);
        return dp(coins, amount, memo);
    }

    private int dp(int[] coins, int rem, int[] memo) {
        if (rem < 0) return -1;    
        if (rem == 0) return 0;     
        if (memo[rem] != -2) return memo[rem]; 

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = dp(coins, rem - coin, memo);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }

        memo[rem] = (min == Integer.MAX_VALUE) ? -1 : min;
        return memo[rem];
    }
}