// 位运算
// 有符号整数的补码表示
// 减法运算转换为补码的加法运算
// 拆分为无进位加法结果与进位结果的和

class Solution {
    public int getSum(int a, int b) {
        // 每次计算进位，加上进位，判断是否还需要进位
        while(b != 0){
            int c = (a & b) << 1;
            a = a ^ b;
            b = c;
        }
        return a;
    }
}