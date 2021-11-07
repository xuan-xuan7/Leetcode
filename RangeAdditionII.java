// 分别找出ops在0和1位置上的min，相乘即可

public class RangeAdditionII {
    public int maxCount(int m, int n, int[][] ops) {
        int x0 = m;
        int x1 = n;
        for(int[] x: ops){
            if(x[0] < x0){
                x0 = x[0];
            }
            if(x[1] < x1){
                x1 = x[1];
            }
        }
        return x0 * x1;
    }
}
