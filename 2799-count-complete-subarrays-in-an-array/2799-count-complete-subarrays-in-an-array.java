class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> distinctElementsSet = new HashSet<>();
        for (int num : nums) {
            distinctElementsSet.add(num);
        }
        int totalDistinct = distinctElementsSet.size();

        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int left = 0, right = 0, result = 0;
        int currentDistinctCount = 0;

        while (right < nums.length) {
            int rightElem = nums[right];
            freqMap.put(rightElem, freqMap.getOrDefault(rightElem, 0) + 1);
            if (freqMap.get(rightElem) == 1) {
                currentDistinctCount++;
            }
            while (currentDistinctCount == totalDistinct) {
                result += nums.length - right;
                int leftElem = nums[left];
                freqMap.put(leftElem, freqMap.get(leftElem) - 1);
                if (freqMap.get(leftElem) == 0) {
                    currentDistinctCount--;
                }
                left++;
            }
            right++;
        }
        return result;
    }
}