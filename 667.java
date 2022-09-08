import java.util.ArrayList;
import java.util.List;

// 按顺序从n个数序列取一头一尾
// 比如[1,2,3,4,5]依次取1,5,2,4,3
// 这样取k个数有k-1个差值，且差值从大到小排列
// 取到n-1个数时有n-2个差值，后面依次排列即可

class Solution {
    public int[] constructArray(int n, int k) {
        List<Integer> ans = new ArrayList<>();
        int head = 1;
        int tail = n;
        int i;
        
        for(i = 1; i < k; i ++){
            if(i % 2 == 1){
                ans.add(head);
                head ++;
            } else {
                ans.add(tail);
                tail --;
            }
        }
        if(i % 2 == 1){
            for(; head <= tail; head ++){
                ans.add(head);
            }
        } else {
            for(; tail >= head; tail --){
                ans.add(tail);
            }
        }

        int[] arrAns = ans.stream().mapToInt(Integer :: valueOf).toArray();

        return arrAns;
    }
}