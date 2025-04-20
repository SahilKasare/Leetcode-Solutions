class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> hash = new HashMap<>();
        int len = answers.length;
        int count = 0;
        for(int ans: answers){
            hash.put(ans, hash.getOrDefault(ans, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : hash.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            int groupsize = key + 1;
            int groups = (int) Math.ceil((double)value/groupsize);
            count += groups * groupsize;
        }
        return count;

    }
}