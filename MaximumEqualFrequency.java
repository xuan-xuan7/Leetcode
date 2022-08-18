// 一共三种情况，做好判断即可

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxEqualFreq(int[] nums) {
        int len = 0;
        // 记录每个数出现的次数
        Map<Integer, Integer> cnt = new HashMap<>();
        // 记录出现cnt次数字的数目
        Map<Integer, Integer> cntNum = new HashMap<>();
        // 记录最大出现次数
        int maxCount = 0;
        int count = 0;

        for(int i = 0; i < nums.length; i ++){
            //放入哈系表
            cnt.put(nums[i], cnt.getOrDefault(nums[i], 0) + 1);
            count = cnt.get(nums[i]);
            if(cntNum.containsKey(count - 1)){
                cntNum.put(count - 1, cntNum.get(count - 1) - 1);
            }
            cntNum.put(count, cntNum.getOrDefault(count, 0) + 1);

            // 比较最大出现次数
            if(maxCount < count){
                maxCount = count;
            }
            

            // 遍历哈系表，判断是否符合定义
            int flag = 0; 
            // 只有一个数出现了最大次数，那么要求其他的数均是最大次数-1次
            if(cntNum.get(maxCount) == 1 && cntNum.get(maxCount) + cntNum.getOrDefault(maxCount - 1, 0) == cnt.size()){
                flag = 1;
            }
            // 所有数字出现次数均为1
            if(cntNum.getOrDefault(1, 0) == cnt.size()){
                flag = 1;
            }
            // 有多个数字出现最大次数，则只能有一个数字出现1次，其余数字均为最大次数
            if(cntNum.getOrDefault(1, 0) == 1 && cntNum.getOrDefault(1, 0) + cntNum.getOrDefault(maxCount, 0) == cnt.size()){
                flag = 1;
            }
            if(flag == 1){
                if(i + 1 > len){
                    len = i + 1;
                }
            }
        }

        return len;
    }
}