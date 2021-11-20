import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        int maxLen = 0;
        int addOne = 0;
        int subOne = 0;
        Map<Integer, Integer> len = new HashMap<>();

        for(int i = 0; i < nums.length; i ++){
            len.put(nums[i], len.getOrDefault(nums[i], 0) + 1);
            addOne = len.get(nums[i]) + len.getOrDefault(nums[i] + 1, -len.get(nums[i]));
            subOne = len.get(nums[i]) + len.getOrDefault(nums[i] - 1, -len.get(nums[i]));
            if(addOne > maxLen){
                maxLen = addOne;
            } else if(subOne > maxLen){
                maxLen = subOne;
            }
        }

        return maxLen;
    }
}
