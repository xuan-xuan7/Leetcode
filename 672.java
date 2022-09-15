import java.util.HashSet;
import java.util.Set;

// 灯泡状态以6为周期重复，其中
// m：6k+1：按钮1.3.4相关
// n：6k，6k+2：按钮1.2相关
// k：6k+3,6k+5：按钮1.3相关
// t：6k+4：按钮1.2.4相关
// 偶数次按压等于没按
// 根据m,n,k可以推断t的状态，只需要观察m,n,t的状态即可
// 三组灯泡的排列组合，可以画图推断
// 按一次：4种
// 按两次：7种
// 按三次及以上：8种
// 以上灯泡数量需要大于等于3

class Solution {
    public int flipLights(int n, int presses) {
        if(presses == 0){
            return 1;
        } else if(n == 1){
            return 2;
        } else if(n == 2){
            return presses == 1 ? 3 : 4;
        } else {
            if(presses == 1){
                return 4;
            } else if(presses == 2){
                return 7;
            } else {
                return 8;
            }
        }
    }
}