// 四种情况
// 1.原数前半部分替换后半部分得到的回文数
// 2.原数前半部分+1替换后半部分得到的回文数
// 3.原数前半部分-1替换后半部分得到的回文数
// 4.直接构造99...99和10...01作为备选答案

import java.util.ArrayList;
import java.util.List;

public class FindtheClosestPalindrome {
    public String nearestPalindromic(String n) {
        long selfNum = Long.parseLong(n);
        long ans = -1;
        List<Long> candidates = getCandidates(n);
        for(long candidate: candidates){
            if(candidate != selfNum){
                if(ans == -1 || Math.abs(candidate - selfNum) < Math.abs(ans - selfNum) || Math.abs(candidate - selfNum) == Math.abs(ans - selfNum) && candidate < ans){
                    ans = candidate;
                }
            }
        }
        return Long.toString(ans);
    }

    public List<Long> getCandidates(String n){
        int len = n.length();
        List<Long> candidates = new ArrayList<Long>();
        candidates.add((long) Math.pow(10, len - 1) - 1);
        candidates.add((long) Math.pow(10, len) + 1);
        long subSlef = Long.parseLong(n.substring(0, (len + 1) / 2));
        for(long i = subSlef - 1; i <= subSlef + 1; i ++){
            StringBuffer sb = new StringBuffer();
            String prefix = String.valueOf(i); //将i转换为字符串
            sb.append(prefix);
            StringBuffer suffix = new StringBuffer(prefix).reverse();
            sb.append(suffix.substring(len & 1)); // 双数长度从0开始取，单数长度从1开始取
            String candidate = sb.toString();
            candidates.add(Long.parseLong(candidate));
        }
        return candidates;
    }
}
