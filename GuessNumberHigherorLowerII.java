// 动态规划
// f[i][j]表示从i到j的花费
// f[i][j] = min(k+max(f[i][k-1], f[k+1][i]))

public class GuessNumberHigherorLowerII {
    public int getMoneyAmount(int n) {
        int[][] f = new int[n+1][n+1];
        f[0][0] = 0;
        for(int i=n-1; i>=1; i--){
            for(int j=i+1; j<=n; j++){
                int minCost = Integer.MAX_VALUE;
                for(int k=i; k<j; k++){
                    int cost = k + Math.max(f[i][k-1], f[k+1][j]);
                    if(cost < minCost){
                        minCost = cost;
                    }
                }
                f[i][j] = minCost;
            }
        }
        return f[1][n];
    }
}
