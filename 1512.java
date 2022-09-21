class Solution {
    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for(int num: nums){
            if(cnt.containsKey(num)){
                count += cnt.get(num);
            }
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
        return count;
    }
}