class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int p : power) {
            freqMap.put(p, freqMap.getOrDefault(p, 0) + 1);
        }
        List<Integer> unique = new ArrayList<>(freqMap.keySet());
        Collections.sort(unique);

        int n = unique.size();
        long[] dp = new long[n];

        for (int i = 0; i < n; i++) {
            int curr = unique.get(i);
            long currTotal = (long) curr * freqMap.get(curr);
            int j = i - 1;
            while (j >= 0 && unique.get(j) >= curr - 2) {
                j--;
            }

            if (j >= 0) {
                currTotal += dp[j];
            }

            dp[i] = i > 0 ? Math.max(dp[i - 1], currTotal) : currTotal;
        }

        return dp[n - 1];
    }
}
