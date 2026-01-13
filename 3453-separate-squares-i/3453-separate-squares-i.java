class Solution {
    public double separateSquares(int[][] squares) {
        double low = Double.MAX_VALUE;
        double high = Double.MIN_VALUE;

        for (int[] s : squares) {
            low = Math.min(low, s[1]);
            high = Math.max(high, s[1] + s[2]);
        }

        // Binary search
        for (int i = 0; i < 60; i++) { 
            double mid = (low + high) / 2.0;

            double below = 0.0;
            double above = 0.0;

            for (int[] s : squares) {
                double y = s[1];
                double l = s[2];
                double top = y + l;
                double area = l * l;

                if (mid <= y) {
                    above += area;
                } else if (mid >= top) {
                    below += area;
                } else {
                    below += (mid - y) * l;
                    above += (top - mid) * l;
                }
            }

            if (below < above) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return (low + high) / 2.0;
    }
}