class Solution {

    static class State {
        int r, c, t;
        long cost;
        State(int r, int c, int t, long cost) {
            this.r = r;
            this.c = c;
            this.t = t;
            this.cost = cost;
        }
    }

    public int minCost(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        long INF = Long.MAX_VALUE / 4;

        long[][][] dist = new long[m][n][k + 1];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                Arrays.fill(dist[i][j], INF);

        List<int[]> cells = new ArrayList<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                cells.add(new int[]{grid[i][j], i, j});

        cells.sort(Comparator.comparingInt(a -> a[0]));

        int[] ptr = new int[k + 1];

        PriorityQueue<State> pq =
                new PriorityQueue<>(Comparator.comparingLong(a -> a.cost));

        dist[0][0][0] = 0;
        pq.offer(new State(0, 0, 0, 0));

        int[] dr = {0, 1};
        int[] dc = {1, 0};

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            if (cur.cost != dist[cur.r][cur.c][cur.t]) continue;

            for (int d = 0; d < 2; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                if (nr < m && nc < n) {
                    long nd = cur.cost + grid[nr][nc];
                    if (nd < dist[nr][nc][cur.t]) {
                        dist[nr][nc][cur.t] = nd;
                        pq.offer(new State(nr, nc, cur.t, nd));
                    }
                }
            }

            if (cur.t < k) {
                int nt = cur.t + 1;
                while (ptr[nt] < cells.size()
                        && cells.get(ptr[nt])[0] <= grid[cur.r][cur.c]) {

                    int[] cell = cells.get(ptr[nt]);
                    int r = cell[1], c = cell[2];

                    if (cur.cost < dist[r][c][nt]) {
                        dist[r][c][nt] = cur.cost;
                        pq.offer(new State(r, c, nt, cur.cost));
                    }
                    ptr[nt]++;
                }
            }
        }

        long ans = INF;
        for (int t = 0; t <= k; t++) {
            ans = Math.min(ans, dist[m - 1][n - 1][t]);
        }

        return (int) ans;
    }
}
