class Solution {
    int MOD = 1000000007;
    int[][] count = new int[10001][14];
    int[][] comb = new int[10001][14];

    public Solution() {
        for (int s = 0; s < 10001; s++) {
            for (int r = 0; r <= Math.min(s, 13); r++) {
                comb[s][r] = (r == 0 || r == s) ? 1 : (comb[s - 1][r - 1] + comb[s - 1][r]) % MOD;
            }
        }

        for (int div = 1; div < 10001; div++) {
            count[div][0]++;
            for (int i = div * 2; i < 10001; i += div) {
                for (int bars = 0; bars < 13; bars++) {
                    if (count[div][bars] > 0)
                        count[i][bars + 1] += count[div][bars];
                }
            }
        }
    }

    public int idealArrays(int n, int maxValue) {
        int res = 0;
        for (int i = 1; i <= maxValue; i++) {
            for (int bars = 0; bars < Math.min(14, n); bars++) {
                res = (int)((res + 1L * count[i][bars] * comb[n - 1][bars]) % MOD);
            }
        }
        return res;
    }
}