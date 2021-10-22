// 出现次数超过n/3的元素最多有2个
// 摩尔投票法：如果要找出超过n/2的元素，则每次选出两个不同元素抵消，到最后只会剩下相同的元素，该元素即为要找的元素

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        int vote1 = 0;
        int vote2 = 0;
        int element1 = 0;
        int element2 = 0;

        for(int num: nums){
            if(vote1 > 0 && num == element1){
                vote1 ++;
            } else if(vote2 > 0 && num == element2){
                vote2 ++;
            } else if(vote1 == 0){
                element1 = num;
                vote1 ++;
            } else if(vote2 == 0){
                element2 = num;
                vote2 ++;
            } else {
                vote1 --;
                vote2--;
            }
        }

        int count1 = 0;
        int count2 = 0;
        if(vote1 > 0 || vote2 > 0){
            for(int num: nums){
                if(num == element1){
                    count1 ++;
                } else if(num == element2){
                    count2 ++;
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        if(count1 > nums.length / 3){
            ans.add(element1);
        }
        if(count2 > nums.length / 3){
            ans.add(element2);
        }
        return ans;
    }
}
