class Solution {
    public int arraySign(int[] nums) {
        int n = nums.length;
        int cnt = 0;

        for(int i = 0; i < n; i ++){
            if(nums[i] == 0){
                return 0;
            } else if(nums[i] < 0){
                cnt ++;
            }
        }
        if(cnt % 2 == 1){
            return -1;
        }
        return 1;
    }
}