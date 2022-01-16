// 贪心算法：维护两个变量first和second
// first维护second之前最小值，second维护first之后最小值，如果存在这样的三元组，在first、second情况下也一定成立

public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int first = nums[0];
        int second = Integer.MAX_VALUE;

        if(nums.length < 3){
            return false;
        }

        for(int num: nums){
            if(num > second){
                return true;
            } else if(num > first){
                second = num;
            } else {
                first = num;
            }
        }

        return false;
    }
}
