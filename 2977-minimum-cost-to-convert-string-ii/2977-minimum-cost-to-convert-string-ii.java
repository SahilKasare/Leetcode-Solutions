class Solution {
    static final long INF = (long) 1e18;

    public long minimumCost(String source, String target,
                            String[] original, String[] changed, int[] cost) {

        int n = source.length();

        Set<String> all = new HashSet<>();
        for (String s : original) all.add(s);
        for (String s : changed) all.add(s);

        List<String> nodes = new ArrayList<>(all);
        int m = nodes.size();

        Map<String, Integer> id = new HashMap<>();
        for (int i = 0; i < m; i++) id.put(nodes.get(i), i);

        long[][] dist = new long[m][m];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < original.length; i++) {
            int u = id.get(original[i]);
            int v = id.get(changed[i]);
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        for (int k = 0; k < m; k++) {
            for (int i = 0; i < m; i++) {
                if (dist[i][k] == INF) continue;
                for (int j = 0; j < m; j++) {
                    if (dist[k][j] == INF) continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        Map<Integer, Map<String, Map<String, Long>>> bestCost = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (dist[i][j] == INF) continue;
                String s = nodes.get(i);
                String t = nodes.get(j);
                if (s.length() != t.length()) continue;

                int L = s.length();
                bestCost
                    .computeIfAbsent(L, x -> new HashMap<>())
                    .computeIfAbsent(s, x -> new HashMap<>())
                    .merge(t, dist[i][j], Math::min);
            }
        }

        long[] dp = new long[n + 1];
        Arrays.fill(dp, INF);
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {

            if (source.charAt(i) == target.charAt(i)) {
                dp[i] = dp[i + 1];
            }

            for (int L : bestCost.keySet()) {
                if (i + L > n) continue;

                String sSub = source.substring(i, i + L);
                Map<String, Map<String, Long>> byLen = bestCost.get(L);
                if (!byLen.containsKey(sSub)) continue;

                String tSub = target.substring(i, i + L);
                Long c = byLen.get(sSub).get(tSub);
                if (c != null) {
                    dp[i] = Math.min(dp[i], c + dp[i + L]);
                }
            }
        }

        return dp[0] == INF ? -1 : dp[0];
    }
}
