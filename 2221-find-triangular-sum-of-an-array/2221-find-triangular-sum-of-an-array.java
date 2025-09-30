class Solution {
    public int triangularSum(int[] nums) {
        while(nums.length > 1){
            int size = nums.length-1;
            int arr[] = new int[size];
            for(int i = 0; i<size; i++){
                arr[i] = (nums[i] + nums[i+1]) % 10;
            }
            nums = arr;
        }
        return nums[0];
    }
}