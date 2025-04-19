class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> newList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(0, target, list, newList, candidates);
        return newList; 
    }
    public void backtrack(int index, int target, List<Integer> list, List<List<Integer>> newList, int[] nums){
        if(target < 0 || index >= nums.length)return;
        if(target == 0){
            newList.add(new ArrayList<>(list));
            return;
        };
        list.add(nums[index]);
        backtrack(index, target-nums[index], list, newList, nums);
        list.remove(list.size()-1);
        backtrack(index+1, target, list, newList, nums);
    }
}