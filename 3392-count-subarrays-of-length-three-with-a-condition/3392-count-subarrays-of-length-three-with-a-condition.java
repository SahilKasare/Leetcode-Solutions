class Solution {
    public int countSubarrays(int[] nums) {
        int last = 2;
        int first = 0;
        int count = 0;
        while(last < nums.length){
            if((nums[first] + nums[last])*2 == nums[first+1]) count++;
            last++;
            first++;
        }
        return count;
    }
}