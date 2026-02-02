class Solution {
    public long minimumCost(int[] nums, int k, int dist) {

        long ans = (long) 10e14;
        TreeSet<Integer> max_pq = new TreeSet<>((a, b) -> nums[a] == nums[b] ? b - a : nums[b] - nums[a]);
        TreeSet<Integer> min_pq = new TreeSet<>((a, b) -> nums[a] == nums[b] ? a - b : nums[a] - nums[b]);

        long sum = 0;
        for (int i = 1; i < Math.min((1 + dist), nums.length); i++) {
            min_pq.add(i);

        }

        for (int i = 1; i < nums.length; i++) {

            if (max_pq.contains(i)) {
                sum -= nums[i];
                max_pq.remove(i);
            } else
                min_pq.remove(i);

            if (i + dist < nums.length) {
                min_pq.add(i + dist);
            }

            // System.out.println(max_pq);
            // System.out.println(min_pq);
            while (max_pq.size() < k - 2 && min_pq.size() > 0) {
                int val = min_pq.first();
                min_pq.remove(val);
                max_pq.add(val);
                sum += nums[val];
            }

            while (max_pq.size() > 0 && min_pq.size() > 0 && nums[max_pq.first()] > nums[min_pq.first()]) {
                int temp = max_pq.first();
                max_pq.remove(temp);
                sum -= nums[temp];
                int temp1 = min_pq.first();
                min_pq.remove(temp1);
                sum += nums[temp1];
                max_pq.add(temp1);
                min_pq.add(temp);
            }

            // System.out.println(i+" "+sum);
            if (max_pq.size() == k - 2)
                ans = Math.min(ans, nums[0] + nums[i] + sum);
        }

        return ans;

    }

}