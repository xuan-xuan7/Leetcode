import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

// 根据题目定义，字符串的首位一定是1,末位一定是0
// 如果一个字符串可以拆分成多个特殊序列，则每一个特殊序列均可移除首尾，递归的进行拆分
// 递归返回后，将所有特殊序列按照字典序进行排序再进行拼接
// 从头遍历字符串，遇到1时加1,遇到0时减1,当计数器为0时就得到整体的特殊序列


class Solution {
    public String makeLargestSpecial(String s) {
        if(s.length() < 2){
            return s;
        } 

        int cnt = 0;
        int left = 0;
        // 保存拆分后的子串
        List<String> subStr = new ArrayList<String>();

        for(int i = 0; i < s.length(); i ++){
            if(s.charAt(i) == '1'){
                cnt ++;
            } else {
                cnt --;
                if(cnt == 0){
                    // 前后先去掉，但添加的时候要补全
                    subStr.add("1" + makeLargestSpecial(s.substring(left + 1, i)) + "0");
                    left = i + 1;
                }
            }
        }

        Collections.sort(subStr, (a, b) -> b.compareTo(a));
        StringBuilder ans = new StringBuilder();
        for(String sub: subStr){
            ans.append(sub);
        }

        return ans.toString();
    }
}