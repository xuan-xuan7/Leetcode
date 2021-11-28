import java.util.ArrayList;
import java.util.List;

public class KRadiusSubarrayAverages {
    public int[] getAverages(int[] nums, int k) {
        int[] ans = new int[nums.length];
        int first = 0;
        int last = 0;
        double sum = 0;
        int len = 2 * k + 1;

        if(nums.length < len){
            for(int i = 0; i < nums.length; i ++){
                ans[i] = -1;
            }
            return ans;
        }

        for(; last < len; last ++){
            sum += nums[last];
        }
        int index = (first + last - 1) / 2;
        for(int i = 0; i < index; i ++){
            ans[i] = -1;
        }
        ans[index] = (int) (sum / len);
        while(last < nums.length){
            sum -= nums[first];
            first ++;
            sum += nums[last];
            last ++;
            index ++;
            ans[index] = (int) (sum / len);
        }
        for(; index < nums.length; index ++){
            ans[index] = -1;
        }
        return ans;
    }
}
