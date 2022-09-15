// 方案数大多为动态规划
// d[i][j]表示在i步操作后下标在j的方案数
// 走太远就回不来了，可以只计算j小于min(arrLen-1, step/2+1)
// d[0][0] = 1, d[0][j] = 0
// d[i][j] = d[i-1][j-1] + d[i-1][j] + d[i-1][j+1] 对应三种操作
// 边界j=min(arrLen-1, step/2+1)，d[i-1][j+1] = 0
// 边界j=0，d[i-1][j-1] = 0
// 注意到d的每一行只和上一行有关，可以只维护上一行，即两个一维数组，而不是一个二维数组


class Solution {
    public int numWays(int steps, int arrLen) {
        final int MODULO = 1000000007;
        int maxLen = Math.min(arrLen - 1, steps / 2 + 1);
        int[] d = new int[maxLen + 1];

        d[0] = 1;
        for(int i = 1; i <= steps; i ++){
            // dpNext记录新走1步时的新状态
            int[] dpNext = new int[maxLen + 1];
            for(int j = 0; j <= maxLen; j ++){
                dpNext[j] = d[j];
                if(j - 1 >= 0){
                    dpNext[j] = (dpNext[j] + d[j - 1]) % MODULO;
                }
                if(j + 1 <= maxLen){
                    dpNext[j] = (dpNext[j] + d[j + 1]) % MODULO;
                }
            }
            // 更新原状态d,用于下一个d的计算，更老的i-2步的状态被覆盖
            d = dpNext;
        }
        
        return d[0];
    }
}