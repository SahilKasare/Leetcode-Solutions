class Solution {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for(int num: nums){
            if(!hashSet.contains(num)){
                hashSet.add(num);
            }else{
                return num;
            }
        }
        return 0;
    }
}