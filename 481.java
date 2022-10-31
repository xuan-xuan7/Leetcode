// 双指针
// i表示需要构造的对应的组的大小
// j表示现在需要构造的对应组的位置

class Solution {
    public int magicalString(int n) {
        if(n < 4){
            return 1;
        }
        char[] s = new char[n];
        s[0] = '1';
        s[1] = '2';
        s[2] = '2';
        int res = 1;
        int i = 2;
        int j = 3;
        
        while(j < n){
            // 要构造的大小
            int size = s[i] - '0';
            // 要构造的数字
            int num = 3 - (s[j - 1] - '0');
            while(size > 0 && j < n){
                s[j] = (char) ('0' + num);
                if(num == 1){
                    res ++;
                }
                j ++;
                size --;
            }
            i ++;
        }

        return res;
    }
}