class Solution {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int n = nums.length;
        int res = n + 1;

        for(int i=0; i<n; i++){
            int num = nums[i];
            if(hashMap.containsKey(num)){
                res = Math.min(res, i-hashMap.get(num));
            }
            hashMap.put(reverse(num), i);
        }

        return res == n+1 ? -1 : res;
    }

    public int reverse(int num){
        int y = 0;
        while(num>0){
            y = y*10 + (num %10);
            num/= 10;
        }
        return y;
    }
}