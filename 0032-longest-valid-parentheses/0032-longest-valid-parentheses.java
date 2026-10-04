class Solution {
    public int longestValidParentheses(String s) {
        int[] f = new int[2], b = new int[2];
        int res = 0, n = s.length();

        for (int i = 0; i < n; i++) {
            f[s.charAt(i) & 1]++;
            if (f[0] == f[1]) res = Math.max(res, f[1] << 1);
            if (f[0] < f[1]) f[0] = f[1] = 0;

            b[s.charAt(n - 1 - i) & 1]++;
            if (b[0] == b[1]) res = Math.max(res, b[1] << 1);
            if (b[0] > b[1]) b[0] = b[1] = 0;
        }

        return res;
    }
}