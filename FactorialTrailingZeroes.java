// 末尾0的数量就是因子10的数量，只有2*5=10，而因子5的数量一定小于2，所以只需要统计所有乘数中因子5的数量之和
// 实现时可以不断将n/5，累加结果

public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int ans = 0;
        while(n / 5 != 0){
            ans += n / 5;
            n /= 5;
        }
        return ans;
    }
}
