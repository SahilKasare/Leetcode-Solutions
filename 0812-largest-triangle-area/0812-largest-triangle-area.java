class Solution {
    public double largestTriangleArea(int[][] points) {
        int size = points.length;
        double area = 0;
        for(int i=0; i<size-2; i++){
            for(int j=1; j<size-1; j++){
                for(int k=2; k<size; k++){
                    area = Math.max(area, Area(points[i][0], points[j][0], points[k][0], points[i][1], points[j][1], points[k][1]));
                }
            }
        }
        return area;
    }

    public double Area(int x1, int x2, int x3, int y1, int y2, int y3) {
        return (0.5) * Math.abs((x1 * (y2 - y3)) + (x2 * (y3 - y1)) + (x3 * (y1 - y2)));
    }
}