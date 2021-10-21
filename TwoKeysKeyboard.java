//质因数分解
//当n可以分解为k个质数的乘积时，代价是k个数相加

public class TwoKeysKeyboard {
    public int minSteps(int n) {
        int step = 0;
        int i;
        if(n == 1){
            return 0;
        }
        for(i=2; i*i<=n; i++){
            while(n % i == 0){
                n = n / i;
                step += i;
            }
        }
        if(n != 1){
            step += n;
        }
        return step;
    }

    public static void main(String[] args){
        TwoKeysKeyboard s = new TwoKeysKeyboard();
        int result = s.minSteps(9);
        System.out.println(result);
    }
}
