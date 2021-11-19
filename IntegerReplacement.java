// 动态规划
// n为偶数：f(n) = f(n/2) + 1
// n为奇数：f(n) = max(f((n-1)/2)+2, f((n+1)/2)+2)

public class IntegerReplacement {
    public int integerReplacement(int n) {
        if(n == 1){
            return 0;
        } else {
            if(n % 2 == 0){
                return integerReplacement(n / 2) + 1;
            } else {
                return Math.min(integerReplacement(n/2), integerReplacement((n/2)+1)) + 2;
            }
        }
    }
}
