// 字典树的前序遍历结果就是字典序排序
// 节点 i 的子节点为 (10 * i, 10 * i + 1, ..., 10 * i + 9)
// 第i层孩子节点个数： first_i记录i层最左侧孩子节点，last_i记录最右侧孩子节点，最右min(n,last_i)

public class KthSmallestinLexicographicalOrder {
    // 字典树从根节点到某个叶节点的搜索过程
    public int findKthNumber(int n, int k) {
        int ans = 1;
        k --;
        while(k > 0){
            int steps = getSteps(ans, n);
            if(steps <= k){ // 去兄弟节点
                k -= steps;
                ans ++;
            } else { //去下层的子节点
                ans = ans * 10;
                k --;
            }
        }
        return ans;
    }

    public int getSteps(int cur, long n){
        int steps = 0;
        long first = cur;
        long last = cur; // 第一层就1个节点
        while(first <= n){ // 逐层计算
            steps += Math.min(n, last) - first + 1;
            first = first * 10;
            last = last * 10 + 9;
        }
        return steps;
    }
}
