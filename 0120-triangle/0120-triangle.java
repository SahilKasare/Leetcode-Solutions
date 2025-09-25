class Solution {
    int[][] memo;

    public int minimumTotal(List<List<Integer>> triangle) {
        memo = new int[triangle.size()][triangle.size()];
        for (int[] row : memo)
            Arrays.fill(row, Integer.MAX_VALUE);
        return helper(triangle, 0, 0);
    }

    private int helper(List<List<Integer>> triangle, int level, int index) {
        if (level == triangle.size() - 1) {
            return triangle.get(level).get(index);
        }

        if (memo[level][index] != Integer.MAX_VALUE)
            return memo[level][index];

        int down = helper(triangle, level + 1, index);
        int downRight = helper(triangle, level + 1, index + 1);

        return memo[level][index] = triangle.get(level).get(index) + Math.min(down, downRight);
    }

}