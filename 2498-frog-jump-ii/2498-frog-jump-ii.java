class Solution {
    public int maxJump(int[] stones) {
        int[] sum = new int[stones.length-1];
        for(int i =0; i<sum.length; i++){
            sum[i] = Math.abs(stones[i] - stones[i+1]);
        }
        int maxjum = sum[0];
        for(int i=0; i<sum.length-1; i++){
            maxjum = Math.max(maxjum, sum[i] + sum[i+1]);
        }
        return maxjum;
    }
}