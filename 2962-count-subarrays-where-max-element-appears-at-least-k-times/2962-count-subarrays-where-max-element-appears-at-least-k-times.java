public class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        int n = nums.length;
        long total = 0;
        int left = 0;
        int maxCount = 0;

        for (int right = 0; right < n; right++) {
            if (nums[right] == max) {
                maxCount++;
            }

            while (maxCount >= k) {
                if (nums[left] == max) {
                    maxCount--;
                }
                left++;
            }

            total += left;
        }

        return total;
    }
}
