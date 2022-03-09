// 先计算k的取值范围
// 元素x的原下标为i，经过轮调后下标为（i-k+n）mod n
// 由下标和得分条件可以得到k的区间为[i-(n+1), i-x]（取n的模）
// 由区间端点的大小得分的范围
// 用差分数组的形式找到被标记最多的k

import java.util.Arrays;

public class SmallestRotationwithHighestScore {
    public int bestRotation(int[] nums) {
        int n = nums.length;
        int[] c = new int[n + 1];
        Arrays.fill(c, 0);
        for(int i = 0; i < n; i ++){
            int a = (i - (n - 1) + n) % n;
            int b = (i - nums[i] + n) % n;
            if(a <= b){
                c[a] += 1;
                c[b + 1] -= 1;
            } else {
                c[0] += 1;
                c[b + 1] -= 1;
                c[a] += 1;
                c[n] -= 1;
            }
        }
        // 类似前缀和，累加后还原累加数组结果
        for(int i = 1; i <= n; i ++){
            c[i] += c[i - 1];
        }
        int ans = 0;
        // i位置上的值相当于k的调度能给多少个元素造成得分
        for(int i = 1; i <= n; i ++){
            if(c[i] > c[ans]){
                ans = i;
            }
        }
        return ans;
    }
}
