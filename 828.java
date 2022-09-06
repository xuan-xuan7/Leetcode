import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 对下标i的字符，当它在某个子字符串中只出现一次时，它会对这个子串统计唯一字符时有贡献
// 对每个字符，计算有多少个字串只包含该字符串一次
// 对于下标为i的字符，上一次出现为j,下一次出现为k，这样的子串一共有（i-j）*（k-i）种
// 从在字符串上统计字符转化到在字符角度上计算字符串

class Solution {
    public int uniqueLetterString(String s) {
        // get each character position
        Map<Character, List<Integer>> index = new HashMap<>();
        int ans = 0;

        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            if(!index.containsKey(c)){
                index.put(c, new ArrayList<Integer>());
                // add start
                index.get(c).add(-1);
            }
            // add current position
            index.get(c).add(i);
        }

        for(Map.Entry<Character, List<Integer>> entry: index.entrySet()){
            List<Integer> arr = entry.getValue();
            // add end
            arr.add(s.length());
            for(int i = 1; i < arr.size() - 1; i ++){
                ans += (arr.get(i) - arr.get(i - 1)) * (arr.get(i + 1) - arr.get(i)); 
            }
        }
         
        return ans;
    }
}