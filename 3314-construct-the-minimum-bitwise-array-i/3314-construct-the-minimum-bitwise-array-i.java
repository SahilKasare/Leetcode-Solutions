class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int p = nums.get(i);
            if ((p & 1) == 0) {
                ans[i] = -1;
                continue;
            }

            int t = 0;
            int temp = p;
            while ((temp & 1) == 1) {
                t++;
                temp >>= 1;
            }
            int k = t - 1;
            int base = (p >> t) << t;
            ans[i] = base - 1 + (1 << k);
        }
        return ans;
    }
}
