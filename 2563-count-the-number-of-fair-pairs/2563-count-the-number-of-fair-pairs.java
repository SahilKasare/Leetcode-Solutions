class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int n = nums.length;
        long count = 0;

        for (int i = 0; i < n; i++) {
            int low = binarySearch(nums, i + 1, n - 1, lower - nums[i], true);
            int high = binarySearch(nums, i + 1, n - 1, upper - nums[i], false);
            count += (high - low + 1);
        }

        return count;
    }

    private int binarySearch(int[] nums, int left, int right, int target, boolean isLowerBound) {
        int ans = isLowerBound ? right + 1 : left - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isLowerBound) {
                if (nums[mid] >= target) {
                    ans = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] <= target) {
                    ans = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return ans;
    }
}
