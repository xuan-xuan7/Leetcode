// 1到k，1到k+1,1到k+2的和 一定有奇数和偶数，那么也就有和target奇偶性相同的和
// 设s为满足s>=target的最小1到k的和
// 如果t=s-target为偶数：
// 如果k>=t/2,只需要选出t/2变号为减
// 否则，先选出k，重复这样的操作
// 如果t为奇数尝试1到k+1和1到k+2即可


class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int k = 0;
        int sum = 0;
        while(sum < target){
            k ++;
            sum += k;
        }
        int t = sum - target;
        if(t % 2 == 1){
            sum += k + 1;
            t = sum - target;
            if(t % 2 == 1){
                return k + 2;
            }
            return k + 1;
        }
        return k;
    }
}