class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) return 0;

        if (k == 0) {
            int zeros = 0;
            for (int x : nums) {
                if (x == 0) zeros++;
            }
            int maxKeep = zeros > 0 ? zeros : 1;
            return n - maxKeep;
        }

        Arrays.sort(nums);

        int left = 0;
        int maxWindow = 1;

        for (int right = 0; right < n; right++) {
            while ((long) nums[right] > (long) k * nums[left]) {
                left++;
            }
            maxWindow = Math.max(maxWindow, right - left + 1);
        }
        return n - maxWindow;
    }
}
