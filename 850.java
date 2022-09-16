import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 扫描线：一条直线从左扫描到右，直线上某些线段会被矩形所覆盖，对这些部分进行积分
*  对n个矩形，上面的线段长度最多变化2n次，对于两次变化，该部分面积为：
*  覆盖的线段长度乘以扫描线在水平方向上走过的距离
*  将所有矩形的左右边界按横坐标排序，确定扫描线的顺序
*  离散化：维护覆盖线段的长度
*  矩形的上下边界有2n个，将y轴分为2n+1个部分，用长度为2n-1的数组seg和length
*  seg[i]表示第i个线段被矩形覆盖的次数，length[i]表示第i个线段长度
*  当扫描线遇到一个左边界时，我们就将左边界覆盖到的线段对应的seg[i]全部加1；遇到一个右边界时，我们就将右边界覆盖到的线段对应的seg[i]全部减1
*  在处理掉一批横坐标相同的左右边界后，seg[i]如果大于0，说明它被覆盖，我们累加所有的length[i]
*/ 


class Solution {
    public int rectangleArea(int[][] rectangles) {
        final int MOD = 1000000007;
        int n = rectangles.length;
        // 记录矩形的纵坐标位置，用于划分线段
        Set<Integer> set = new HashSet<>();
        for(int[] rect: rectangles){
            set.add(rect[1]);
            set.add(rect[3]);
        }
        List<Integer> hbound = new ArrayList<Integer>(set);
        Collections.sort(hbound);
        // y轴被划分的区间数量
        int m = hbound.size();
        // length[i]=hbound[i+1]-hbound[i]
        // 只记录seg即可
        int[] seg = new int[m - 1];

        List<int[]> sweep = new ArrayList<>();
        for(int i = 0; i < n; i ++){
            // 1代表左边界
            sweep.add(new int[]{rectangles[i][0], i, 1});
            // -1代表右边界
            sweep.add(new int[]{rectangles[i][2], i, -1});
        }

        // 先按横坐标排序，相等按矩形次序排序，仍相等按左右边界排序
        Collections.sort(sweep, (a, b) -> {
            if(a[0] != b[0]){
                return a[0] - b[0];
            } else if(a[1] != b[1]){
                return a[1] - b[1];
            } else {
                return a[2] - b[2];
            }
        });

        long ans = 0;
        // 从横坐标开始遍历
        for(int i = 0; i < sweep.size(); i ++){
            int j = i;
            // 一次性处理相同横坐标
            while(j + 1 < sweep.size() && sweep.get(i)[0] == sweep.get(j + 1)[0]){
                j ++;
            }
            if(j + 1 == sweep.size()){
                break;
            }
            // 处理seg
            for(int k = i; k <= j; k ++){
                int[] arr = sweep.get(k);
                // idx为rectangle序号
                int idx = arr[1];
                // diff为左右边界标记
                int diff = arr[2];
                int bottom = rectangles[idx][1];
                int top =  rectangles[idx][3];
                // 上下起始位置之间的线段均被操作
                for(int x = 0; x < m - 1; x ++){
                    if(bottom <= hbound.get(x) && hbound.get(x + 1) <= top){
                        seg[x] += diff;
                    }
                }
            }

            int cover = 0;
            // 遍历y轴上的每个线段，计算该横坐标处的cover值
            for(int k = 0; k < m - 1; k ++){
                if(seg[k] > 0){
                    cover += (hbound.get(k + 1) - hbound.get(k));
                }
            }
            // 计算这两个横坐标区间内的面积
            ans += (long) cover * (sweep.get(j + 1)[0] - sweep.get(j)[0]);
            i = j;
        }

        return (int)(ans % MOD);
   }
}