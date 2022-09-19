import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> frequency = new HashMap<>();
        
        for(int i = 0; i < nums.length; i ++){
            frequency.put(nums[i], frequency.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer> ans = new ArrayList<>();
        for(int num: nums){
            ans.add(num);
        }

        Collections.sort(ans, (a, b) -> {
            int f1 = frequency.get(a);
            int f2 = frequency.get(b);
            return f1 != f2 ? f1 - f2 : b - a;
        });

        for(int i = 0; i < nums.length; i ++){
            nums[i] = ans.get(i);
        }

        return nums;
    }
}