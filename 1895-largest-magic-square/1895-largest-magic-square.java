class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] rowSum = new int[m][n + 1];
        int[][] colSum = new int[m + 1][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i][j + 1] = rowSum[i][j] + grid[i][j];
                colSum[i + 1][j] = colSum[i][j] + grid[i][j];
            }
        }

        int maxSize = Math.min(m, n);

        for (int k = maxSize; k >= 2; k--) {
            for (int i = 0; i + k <= m; i++) {
                for (int j = 0; j + k <= n; j++) {
                    if (isMagic(grid, rowSum, colSum, i, j, k)) {
                        return k;
                    }
                }
            }
        }

        return 1; 
    }

    private boolean isMagic(int[][] grid, int[][] rowSum, int[][] colSum,
                            int r, int c, int k) {

        int target = rowSum[r][c + k] - rowSum[r][c];

        // Check all rows
        for (int i = r; i < r + k; i++) {
            if (rowSum[i][c + k] - rowSum[i][c] != target) {
                return false;
            }
        }

        for (int j = c; j < c + k; j++) {
            if (colSum[r + k][j] - colSum[r][j] != target) {
                return false;
            }
        }

        int diag1 = 0;
        for (int i = 0; i < k; i++) {
            diag1 += grid[r + i][c + i];
        }
        if (diag1 != target) return false;

        int diag2 = 0;
        for (int i = 0; i < k; i++) {
            diag2 += grid[r + i][c + k - 1 - i];
        }
        return diag2 == target;
    }
}
