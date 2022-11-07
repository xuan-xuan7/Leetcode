import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> ambiguousCoordinates(String s) {
        int n = s.length() - 2;
        s = s.substring(1, s.length() - 1);
        List<String> ans = new ArrayList<>();

        for(int i = 1; i < n; i ++){
            List<String> lt = getPos(s.substring(0, i));
            if(lt.isEmpty()){
                continue;
            }
            List<String> rt = getPos(s.substring(i));
            if(rt.isEmpty()){
                continue;
            }
            for(String ls: lt){
                for(String rs: rt){
                    ans.add("(" + ls + ", " + rs + ")");
                }
            }
        }

        return ans;
    }

    private List<String> getPos(String s){
        // 该函数只考虑小数点加在那的问题
        List<String> pos = new ArrayList<>();
        // 单独就能成为一个坐标
        if(s.charAt(0) != '0' || "0".equals(s)){
            pos.add(s);
        }
        for(int i = 1; i < s.length(); i ++){
            if((i != 1 && s.charAt(0) == '0') || s.charAt(s.length() - 1) == '0'){
                continue;
            }
            pos.add(s.substring(0, i) + "." + s.substring(i));
        }
        return pos;
    }
}