class Solution {
    public int sumOfSquares(int[] nums) {
        int last = nums.length;
        int sum = 0;
        int count = 0;
        for(int num: nums){
            count++;
            if(last % count == 0){
                sum += Math.pow(num, 2);
            }
        }
        return sum;
    }
}