// 用长度为n位的整数的数组记录子集情况，第i位为1则表示选择该元素，数组对应位记录子集按位或的值
// 长度为n位的状态可以由长度为n-1位的状态得到
// 定义一个搜索函数，pos表示当前下标，orVal表示当前下标之间某个子集按位或的值，根据当前元素选择情况更新orVal

public class CountNumberofMaximumBitwiseORSubsets {
    int[] nums;
    int maxOr;
    int cnt;

    public int countMaxOrSubsets(int[] nums) {
        this.nums =nums;
        this.maxOr = 0;
        this.cnt = 0;
        dfs(0, 0);
        return cnt;
    }

    public void dfs(int pos, int orVal){
        if(pos == nums.length){
            if(orVal > maxOr){
                maxOr = orVal;
                cnt = 1;
            } else if(orVal == maxOr){
                cnt ++;
            }
            return;
        }
        // 选择该位置元素的情况
        dfs(pos + 1, orVal | nums[pos]);
        // 不选择该位置元素的情况
        dfs(pos + 1, orVal);
    }
}
