// 贪心
// 长度为n的数组包含0～n-1的不同n个正整数
// 排序完成后arr[i]=i
// 当0～i-1位置上的元素最大值是i时可以完成排序


class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int cnt = 0;
        int curMax = 0;

        for(int i = 0; i < n; i ++){
            curMax = Math.max(curMax, arr[i]);
            if(curMax == i){
                cnt ++;
            }
        }

        return cnt;
    }
}