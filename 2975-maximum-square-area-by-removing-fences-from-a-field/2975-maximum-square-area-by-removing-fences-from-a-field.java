class Solution {

    private static final long MOD = 1_000_000_007L;

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int[] h = new int[hFences.length + 2];
        int[] v = new int[vFences.length + 2];

        h[0] = 1;
        h[h.length - 1] = m;
        v[0] = 1;
        v[v.length - 1] = n;

        for (int i = 0; i < hFences.length; i++) {
            h[i + 1] = hFences[i];
        }
        for (int i = 0; i < vFences.length; i++) {
            v[i + 1] = vFences[i];
        }

        Arrays.sort(h);
        Arrays.sort(v);

        Set<Integer> verticalDiffs = new HashSet<>();
        for (int i = 0; i < v.length; i++) {
            for (int j = i + 1; j < v.length; j++) {
                verticalDiffs.add(v[j] - v[i]);
            }
        }

        long maxSide = -1;

        for (int i = 0; i < h.length; i++) {
            for (int j = i + 1; j < h.length; j++) {
                int diff = h[j] - h[i];
                if (verticalDiffs.contains(diff)) {
                    maxSide = Math.max(maxSide, diff);
                }
            }
        }

        if (maxSide == -1)
            return -1;

        long area = (maxSide * maxSide) % MOD;
        return (int) area;
    }
}
