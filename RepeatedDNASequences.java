// 一共只有4个字母，可以用2位二进制表示，10个字母为20位，可以用int类型表示一个10字母的子串
// 只需要扫描一遍数组，复杂度O(n)
// 位运算重点

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<Character, Integer> bin = new HashMap<Character, Integer>();
        bin.put('A', 0);
        bin.put('C', 1);
        bin.put('G', 2);
        bin.put('T', 3);
        int length = 10;
        List<String> ans = new ArrayList<String>();
        int n = s.length();

        if(n <= length){
            return ans;
        }

        int i;
        int num = 0;
        for(i=0; i<length-1; i++){
            num = (num << 2) | bin.get(s.charAt(i));
        }
        // 先将num左移两位，然后按位进行或操作，在这里相当于在后面添上新的两位数字
        HashMap<Integer, Integer> search = new HashMap<Integer, Integer>();
        int count = 0b11111111111111111111;
        for(i=0; i<=n-length; i++){
            num = (num << 2) | bin.get(s.charAt(i+length-1)) & count;
            // 消去多余的两位
            search.put(num, search.getOrDefault(num, 0) + 1);
            if(search.get(num) == 2){
                ans.add(s.substring(i, i+length));
            }
        }

        return ans;
    }
}
