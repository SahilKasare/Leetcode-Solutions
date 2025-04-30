class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int num : nums){
            String str = Integer.toString(num);
            count = str.length() % 2 == 0 ? count + 1 : count;
        }
        return count;
    }
}