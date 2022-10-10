// 动态规划
// dp[i][0]表示到位置i且位置i不交换的满足条件的最小操作数，dp[i][1]表示位置i交换
// 情况1：nums1[i]>nums1[i-1]
// 情况2：nums1[i]>nums2[i-1]
// 所以位置i是否交换只和位置i-1有关
// 1.满足情况1：位置i的交换和位置i-1保持一致
// 2.满足情况2：位置i的交换和位置i-1相反
// 3.同时满足情况1和2：取两者中的较小值

class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        // dp[0][0]
        int a = 0;
        // dp[0][1]
        int b = 1;

        for(int i = 1; i < n; i ++){
            int at = a;
            int bt = b;
            // 为了单独满足情况2下的操作
            a = n;
            b = n;
            if(nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]){
                a = at;
                b = bt + 1;
            }
            if(nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]){
                a = Math.min(a, bt);
                b = Math.min(b, at + 1);
            }
        }

        return Math.min(a, b);
    }
}