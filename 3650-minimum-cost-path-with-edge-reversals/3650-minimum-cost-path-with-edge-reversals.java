class Solution {
    static class Edge {
        int to;
        long cost;
        Edge(int t, long c) {
            to = t;
            cost = c;
        }
    }

    public int minCost(int n, int[][] edges) {
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, 2L * w)); 
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<long[]> pq =
                new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int node = (int) cur[0];
            long d = cur[1];

            if (d > dist[node]) continue;
            if (node == n - 1) return (int) d;

            for (Edge e : graph.get(node)) {
                long nd = d + e.cost;
                if (nd < dist[e.to]) {
                    dist[e.to] = nd;
                    pq.offer(new long[]{e.to, nd});
                }
            }
        }
        return -1;
    }
}
