import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindTargetIndicesAfterSortingArray {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<Integer>();

        int left = 0;
        int right = nums.length - 1;
        int mid = left + (right - left) / 2;
        while(left < right){
            mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            } else if(nums[mid] > target){
                right = mid;
            } else {
                break;
            }
        }
        if(left == right && nums[left] != target){
            return ans;
        }
        for(int i = mid; i >= left; i --){
            if(nums[i] == target){
                ans.add(i);
            } else {
                break;
            }
        }
        for(int i = mid + 1; i <= right; i ++){
            if(nums[i] == target){
                ans.add(i);
            } else {
                break;
            }
        }
        ans.sort(Comparator.naturalOrder());

        return ans;
    }
}
