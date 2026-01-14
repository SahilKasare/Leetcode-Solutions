class Solution {

    static class Event {
        double y;
        int x1, x2;
        int type; 
        
        Event(double y, int x1, int x2, int type) {
            this.y = y;
            this.x1 = x1;
            this.x2 = x2;
            this.type = type;
        }
    }

    static class SegmentTree {
        int[] count;
        double[] length;
        double[] xs;
        int n;

        SegmentTree(double[] xs) {
            this.xs = xs;
            this.n = xs.length - 1;
            count = new int[n * 4];
            length = new double[n * 4];
        }

        void update(int node, int l, int r, int ql, int qr, int val) {
            if (qr <= l || r <= ql) return;

            if (ql <= l && r <= qr) {
                count[node] += val;
            } else {
                int mid = (l + r) >> 1;
                update(node << 1, l, mid, ql, qr, val);
                update(node << 1 | 1, mid, r, ql, qr, val);
            }

            if (count[node] > 0) {
                length[node] = xs[r] - xs[l];
            } else if (l + 1 == r) {
                length[node] = 0;
            } else {
                length[node] = length[node << 1] + length[node << 1 | 1];
            }
        }

        double query() {
            return length[1];
        }
    }

    public double separateSquares(int[][] squares) {

        List<Event> events = new ArrayList<>();
        Set<Integer> xSet = new HashSet<>();

        for (int[] s : squares) {
            int x = s[0], y = s[1], l = s[2];
            events.add(new Event(y, x, x + l, 1));
            events.add(new Event(y + l, x, x + l, -1));
            xSet.add(x);
            xSet.add(x + l);
        }

        double[] xs = xSet.stream().sorted().mapToDouble(i -> i).toArray();
        Map<Double, Integer> xIndex = new HashMap<>();
        for (int i = 0; i < xs.length; i++) xIndex.put(xs[i], i);

        events.sort(Comparator.comparingDouble(e -> e.y));

        // 1) Compute total union area
        SegmentTree st = new SegmentTree(xs);
        double totalArea = 0;
        double prevY = events.get(0).y;

        for (Event e : events) {
            double dy = e.y - prevY;
            totalArea += st.query() * dy;

            st.update(1, 0, st.n,
                    xIndex.get((double) e.x1),
                    xIndex.get((double) e.x2),
                    e.type);

            prevY = e.y;
        }

        // 2) Find split point
        double half = totalArea / 2.0;
        st = new SegmentTree(xs);
        prevY = events.get(0).y;
        double area = 0;

        for (Event e : events) {
            double dy = e.y - prevY;
            double curWidth = st.query();
            double stripArea = curWidth * dy;

            if (area + stripArea >= half) {
                return prevY + (half - area) / curWidth;
            }

            area += stripArea;

            st.update(1, 0, st.n,
                    xIndex.get((double) e.x1),
                    xIndex.get((double) e.x2),
                    e.type);

            prevY = e.y;
        }

        return prevY;
    }
}
