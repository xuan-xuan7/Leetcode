// DFS回溯+剪枝

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses {
    private List<String> res = new ArrayList<String>();

    public List<String> removeInvalidParentheses(String s) {
        int lremove = 0;
        int rremove = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                lremove ++;
            } else if(s.charAt(i) == ')'){
                if(lremove > 0){
                    lremove --;
                } else {
                    rremove ++;
                }
            }
        }

        dfs(s, 0, 0, 0, lremove, rremove);
        return res;
    }

    public void dfs(String s, int start, int lcount, int rcount, int lremove, int rremove){
        if(lremove == 0 && rremove == 0){
            if(isValid(s)){
                res.add(s);
            }
            return;
        }
        for(int i=start; i<s.length(); i++){
            // 连续相同的字符考虑删除最后一个
            // 去重
            if(i != start && s.charAt(i) == s.charAt(i-1)){
                if(s.charAt(i) == '('){
                    lcount ++;
                }
                if(s.charAt(i) == ')'){
                    rcount ++;
                }
                continue;
            }
            // 剩余字符不足以完成删除
            if(lremove + rremove > s.length() - i){
                return;
            }
            if(lremove > 0 && s.charAt(i) == '('){
                dfs(s.substring(0, i) + s.substring(i+1), i, lcount, rcount, lremove-1, rremove);
            }
            if(rremove > 0 && s.charAt(i) == ')'){
                dfs(s.substring(0, i) + s.substring(i+1), i, lcount, rcount, lremove, rremove-1);
            }
            if(s.charAt(i) == '('){
                lcount ++;
            }
            if(s.charAt(i) == ')'){
                rcount ++;
            }
            if(lcount < rcount){
                break;
            }
        }
    }

    public boolean isValid(String s){
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                count ++;
            } else if(s.charAt(i) == ')'){
                count --;
                if(count < 0){
                    return false;
                }
            }
        }
        return count == 0;
    }
}
