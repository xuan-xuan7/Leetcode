//动态规划，考虑长度为k-1的子序列的情况
//维护一个数组来纪录i个数组长度时

public class NumberOfLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        int num = 0;
        int[] subLong = new int[nums.length];
        int[] subLongNum = new int[nums.length];
        int i,j;
        int maxLong = 1;
        for(i=0; i<nums.length; i++){
            subLong[i] = 1;
            subLongNum[i] = 1;
            for(j=0; j<i; j++){
                if(nums[i] > nums[j]){
                    if(subLong[j] + 1 > subLong[i]){
                        subLong[i] = subLong[j] + 1;
                        subLongNum[i] = subLongNum[j];
                    } else if(subLong[i] == subLong[j] + 1){
                        subLongNum[i] += subLongNum[j];
                    }
                }
            }
            maxLong = Math.max(maxLong, subLong[i]);
        }
        for(i=0; i<nums.length; i++){
            if(subLong[i] == maxLong){
                num += subLongNum[i];
            }
        }
        return num;
    }

    public static void main(String[] args) {
        NumberOfLongestIncreasingSubsequence s = new NumberOfLongestIncreasingSubsequence();
        int result;
        int[] nums = {1, 3, 5, 4, 7};
        result = s.findNumberOfLIS(nums);
        System.out.println(result);
    }
}
