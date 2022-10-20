// n & (n - 1) 运算结果为：把n最低位的1变为0
// 那么：做了多少次 n & (n - 1)运算，就有多少个1

class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int cnt = 0;

        while(n != 0){
            n &= n - 1;
            cnt ++;
        }

        return cnt;
    }
}