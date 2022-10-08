import java.util.Arrays;

// 贪心
// 排序两个数组，从头开始遍历
// 若nums1能够匹配nums2，则最小匹配，若不能则匹配nums2中剩余最大元素

class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Integer[] idx1 = new Integer[n];
        Integer[] idx2 = new Integer[n];
        for(int i = 0; i < n; i ++){
            idx1[i] = i;
            idx2[i] = i;
        }
        Arrays.sort(idx1, (i, j) -> nums1[i] - nums1[j]);
        Arrays.sort(idx2, (i, j) -> nums2[i] - nums2[j]);

        int[] ans = new int[n];
        int left = 0;
        int right = n - 1;
        for(int i = 0; i < n; i ++){
            if(nums1[idx1[i]] > nums2[idx2[left]]){
                ans[idx2[left]] = nums1[idx1[i]];
                left ++;
            } else {
                ans[idx2[right]] = nums1[idx1[i]];
                right --;
            }
        }

        return ans;
    }
}