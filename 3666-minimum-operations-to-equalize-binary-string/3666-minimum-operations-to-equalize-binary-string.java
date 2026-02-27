class Solution {
    public int minOperations(String s, int k) {
        int n = s.length();
        int c = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                c++;
            }
        }
        if (c == 0) {
            return 0;
        }
        if (k % 2 == 0 && c % 2 != 0) {
            return -1;
        }
        if (k == n) {
            return c == n ? 1 : -1;
        }

        int m0 = (c + k - 1) / k;
        int step = 1;
        if (k % 2 == 1) {
            if (m0 % 2 != c % 2) {
                m0++;
            }
            step = 2;
        }

        long m = m0;
        while (true) {
            if (m % 2 == 1) {
                if (m * k <= (long) n * (m - 1) + c) {
                    return (int) m;
                }
            } else {
                if (m * k <= (long) n * m - c) {
                    return (int) m;
                }
            }
            m += step;
        }
    }
}