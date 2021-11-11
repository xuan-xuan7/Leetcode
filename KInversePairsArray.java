// 动态规划
// 用f[i][j]表示长度为i的数组组成含有j个逆序的个数
// 考虑1到i这i个数字，构成的序列为1～（k-1）+（k+1）～i+k，对选择的数字k来说，逆序的构成为：
// 1.k和除k以外的i-1个元素构成的逆序对数（i-k）个
// 2.这i-1个元素内部的逆序对数
// 对于情况2，将k+1～i元素均减少1，构成新的i-1个数的序列，子任务为f[i-1][j-(i-k)]
// 状态转移方程：f[i][j]=f[i-1][j-(i-k)]中k从1到i求和=f[i-1][j-k]中k从0到i-1求和
// 考虑f[i][j]和f[i][j-1]的关系，递推关系优化为：
// f[i][j]=f[i][j-1]-f[i-1][j-i]+f[i-1][j]

public class KInversePairsArray {
    public int kInversePairs(int n, int k) {
        final int MOD = 1000000007;
        int[][] f = new int[2][k+1];
        f[0][0] = 1;
        for(int i=1; i<=n; i++){
            for(int j=0; j<=k; j++){
                // 确定当前和之前结果存储在哪一个数组中
                int cur = i & 1;
                int prev = cur ^ 1;
                if(j-1 < 0){
                    if(j-i < 0) {
                        f[cur][j] = f[prev][j];
                    } else {
                        f[cur][j] = f[prev][j] - f[prev][j-i];
                    }
                } else {
                    if(j-i < 0) {
                        f[cur][j] = f[cur][j-1] + f[prev][j];
                    } else {
                        f[cur][j] = f[cur][j-1] - f[prev][j-i] + f[prev][j];
                    }
                }
                if (f[cur][j] >= MOD) {
                    f[cur][j] -= MOD;
                } else if (f[cur][j] < 0) {
                    f[cur][j] += MOD;
                }
            }
        }

        return f[n & 1][k];
    }
}
