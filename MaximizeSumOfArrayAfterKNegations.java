// 负转正，mod 2，看是否需要改变最小正数

import java.util.Arrays;

public class MaximizeSumOfArrayAfterKNegations {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        int minusNum = 0;
        while(minusNum < nums.length && nums[minusNum] < 0){
            minusNum ++;
        }
        if(minusNum >= k){
            for(int i=0; i<k; i++){
                nums[i] = -nums[i];
            }
            for (int num : nums) {
                sum += num;
            }
        } else {
            for(int i=0; i<minusNum; i++){
                nums[i] = -nums[i];
            }
            int op = (k - minusNum) % 2;
            if(op == 1){
                Arrays.sort(nums);
                nums[0] = -nums[0];
            }
            for (int num : nums) {
                sum += num;
            }
        }
        return sum;
    }
}
