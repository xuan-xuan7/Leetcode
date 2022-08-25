import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    private int left;
    private int right;

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        left = 0;
        right = arr.length - 1;

        binarySearch(arr, x);

        while(ans.size() != k){
            if(left >= 0 && right <= arr.length - 1){
                if(Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)){
                    ans.add(arr[left]);
                    left --;
                } else if(Math.abs(arr[left] - x) > Math.abs(arr[right] - x)){
                    ans.add(arr[right]);
                    right ++;
                }
            } else if(left >= 0){
                ans.add(arr[left]);
                left --;
            } else if(right <= arr.length - 1){
                ans.add(arr[right]);
                right ++;
            }
        }

        Collections.sort(ans);

        return ans;
    }

    private void binarySearch(int[] arr, int x){
        int mid = 0;
        while(left < right - 1){
            mid = (right - left) / 2 + left;
            if(arr[mid] < x){
                left = mid;
            } else if(arr[mid] > x){
                right = mid;
            } else {
                left = mid;
                right = mid + 1;
            }
        }
    }
}