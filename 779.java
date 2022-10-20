// 递归
// 后半部分为的反转前半部分

class Solution {
    public int kthGrammar(int n, int k) {
        if(n == 1){
            return 0;
        }
        // 是后半部分元素则参考前半部分翻转一次
        if(k > (1 << (n - 2))) {
            return 1 ^ kthGrammar(n - 1, k - (1 << (n - 2)));
        }
        return kthGrammar(n - 1, k);
    }
}