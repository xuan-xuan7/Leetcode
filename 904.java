// 滑动窗口

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0;
        int right = 0;
        Map<Integer, Integer> category = new HashMap<>();
        int n = fruits.length;
        int max = 0;
        int len = 0;

        for(; right < n; right ++){
            category.put(fruits[right], category.getOrDefault(fruits[right], 0) + 1);
            while(category.size() > 2){
                category.put(fruits[left], category.get(fruits[left]) - 1);
                if(category.get(fruits[left]) == 0){
                    category.remove(fruits[left]);
                }
                left ++;
            }
            len = right - left + 1;
            max = Math.max(max, len);
        }

        return max;
    }
}