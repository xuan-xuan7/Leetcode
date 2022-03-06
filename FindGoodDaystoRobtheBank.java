// 动态规划

import java.util.ArrayList;
import java.util.List;

public class FindGoodDaystoRobtheBank {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> ans = new ArrayList<>();
        int len = security.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = 0;
        right[len - 1] = 0;
        for(int i = 1; i < len; i ++){
            if(security[i - 1] >= security[i]){
                left[i] = left[i - 1] + 1;
            }
        }
        for(int i = len - 2; i >= 0; i --){
            if(security[i] <= security[i + 1]){
                right[i] = right[i + 1] + 1;
            }
        }
        for(int i = 0; i < len; i ++){
            if(left[i] >= time && right[i] >= time){
                ans.add(i);
            }
        }
        return ans;
    }
}
