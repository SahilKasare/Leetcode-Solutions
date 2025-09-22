class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int maxCount = 0;
        for (int num : nums) {
            int val = hashMap.getOrDefault(num, 0);
            if (val > 0) {
                hashMap.put(num, val + 1);
                maxCount = Math.max(maxCount, val + 1);
            } else {
                hashMap.put(num, 1);
                maxCount = Math.max(maxCount, 1);
            }
        }
        int count = 0;
        for (int key : hashMap.keySet()) {
            int val = hashMap.get(key);
            if(val == maxCount) count = count + val;    
        }
        return count;
    }
}